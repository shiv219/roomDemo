package com.shiv.demo.features.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.shiv.demo.data.local.sharedPreference.AppPreferences
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SplashViewModel @ViewModelInject constructor(val appPreference: AppPreferences) : ViewModel()