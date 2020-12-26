package com.shiv.demo.features.home.users

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.shiv.demo.R
import com.shiv.demo.base.BaseFragment
import com.shiv.demo.data.network.Constant
import com.shiv.demo.databinding.FragmentHomeBinding
import com.shiv.demo.ext.showToast
import com.shiv.demo.ext.toVisibility
import com.shiv.demo.features.home.adapter.UserListAdapter
import com.shiv.demo.features.home.paging.pagingAdapter.ReposLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
@AndroidEntryPoint
class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val mHomeViewModel: HomeViewModel by viewModels()
    private var job: Job? = null

    lateinit var mBinding: FragmentHomeBinding

    @Inject
    lateinit var mUserListAdapter: UserListAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = FragmentHomeBinding.bind(view)
        mBinding.lifecycleOwner = viewLifecycleOwner
        mBinding.mHomeViewModel = mHomeViewModel
        onAdapterItemClick()
        setUpSwipeToRefresh(mBinding)
        initUserListAdapter(mBinding)
        getUser()
    }

   private fun onAdapterItemClick(){
       mUserListAdapter.onClick = { data ->
           HomeFragmentDirections.actionHomeFragmentToUserDetailFragment(
               userId = data.id!!
           ).also {
               findNavController().navigate(it)
           }

        }
    }

    private fun setUpSwipeToRefresh(mBinding: FragmentHomeBinding) {
        mBinding.swipeRefreshLayout.setOnRefreshListener {
            mUserListAdapter.refresh()
            mBinding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun initUserListAdapter(mBinding: FragmentHomeBinding) {
        with(mBinding) {

            rvUsers.adapter = mUserListAdapter.withLoadStateFooter(
                footer = ReposLoadStateAdapter { mUserListAdapter.retry() }
            )
            mUserListAdapter.addLoadStateListener { loadState ->
                if (loadState.source.refresh !is LoadState.NotLoading) {
                    progressBar.visibility = toVisibility(loadState.refresh is LoadState.Loading)
                    btnRetry.visibility = toVisibility(loadState.refresh is LoadState.Error)
                } else {
                    progressBar.visibility = View.GONE
                    btnRetry.visibility = View.GONE
                    swipeRefreshLayout.isRefreshing = false
                    val errorState = when {
                        loadState.append is LoadState.Error -> {
                            loadState.append as LoadState.Error
                        }
                        loadState.prepend is LoadState.Error -> {
                            loadState.prepend as LoadState.Error
                        }
                        else -> {
                            null
                        }
                    }
                    errorState?.let {
                        if (it.error.toString().contains(Constant.remote_key).not())
                            requireContext().showToast(it.error.toString())
                    }
                }
            }
        }
    }

    private fun getUser() {
        job?.cancel()
        job = lifecycleScope.launch {
            mHomeViewModel.users.collectLatest {
                mUserListAdapter.submitData(it)

            }
        }
    }

}