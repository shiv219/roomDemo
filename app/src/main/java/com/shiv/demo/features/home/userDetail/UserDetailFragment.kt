package com.shiv.demo.features.home.userDetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.shiv.demo.R
import com.shiv.demo.base.BaseFragment
import com.shiv.demo.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : BaseFragment(R.layout.fragment_profile) {

    private val mUserDetailViewModel: UserDetailViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mBinding = FragmentProfileBinding.bind(view)
        mBinding.lifecycleOwner = viewLifecycleOwner
        mBinding.onClickListener = this
        mBinding.mViewModel = mUserDetailViewModel
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack -> {
                onBackPressed()
            }
        }
    }

}