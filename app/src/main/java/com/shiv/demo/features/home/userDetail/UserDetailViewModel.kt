package com.shiv.demo.features.home.userDetail

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.shiv.demo.data.local.db.AppDatabase

class UserDetailViewModel @ViewModelInject constructor(
    database: AppDatabase,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val user = database.usersDao().fetchUser(savedStateHandle.get("userId")?:0).asLiveData()

}