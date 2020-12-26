package com.shiv.demo.features.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shiv.demo.data.local.sharedPreference.AppPreferences
import com.shiv.demo.data.repository.AppRepository
import com.shiv.demo.data.resposne.LoginRequest
import com.shiv.demo.ext.toLoadingState
import com.shiv.demo.utils.CommonUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOn

@ExperimentalCoroutinesApi
class LoginViewModel @ViewModelInject constructor(
    val repository: AppRepository,
    val appPreference: AppPreferences,
    val commonUtils: CommonUtils
) : ViewModel() {
    var request = MutableLiveData(LoginRequest())
    var isPasswordViewEnabled = MutableLiveData(false)

    val login = repository.login(request.value!!).toLoadingState().flowOn(Dispatchers.IO)
}