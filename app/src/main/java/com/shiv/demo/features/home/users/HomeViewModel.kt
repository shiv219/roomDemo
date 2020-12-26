package com.shiv.demo.features.home.users

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.shiv.demo.data.local.sharedPreference.AppPreferences
import com.shiv.demo.data.local.sharedPreference.SharedPreferenceKey
import com.shiv.demo.data.repository.AppRepository
import kotlinx.coroutines.flow.collect

class HomeViewModel @ViewModelInject constructor(
    repository: AppRepository,
    private var appPreferences: AppPreferences
) : ViewModel() {
    var count = liveData {
        appPreferences.getValueFlow(SharedPreferenceKey.userCount, "").collect {
            emit(it)
        }
    }
    val users = repository.getUserData().cachedIn(viewModelScope)

}