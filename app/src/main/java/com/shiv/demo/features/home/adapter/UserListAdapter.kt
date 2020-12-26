package com.shiv.demo.features.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shiv.demo.R
import com.shiv.demo.data.resposne.UserData
import com.shiv.demo.databinding.ListItemUserBinding
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class UserListAdapter @Inject constructor():
    PagingDataAdapter<UserData, UserListAdapter.UserViewHolder>(diffCallback) {
     var onClick: ((userData :UserData) -> Unit)?=null
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) =
        UserViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.list_item_user, parent
                , false
            )
        )

    inner class UserViewHolder(private val mBinding: ListItemUserBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        fun bind(user: UserData) {
            with(mBinding) {
                userEmail = user.email
                tvUserEmail.setOnClickListener {
                    onClick?.let { it1 -> it1(user) }
                }
            }
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<UserData>() {
            override fun areItemsTheSame(oldItem: UserData, newItem: UserData) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UserData, newItem: UserData) =
                oldItem == newItem
        }
    }
}
