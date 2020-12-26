package com.shiv.demo.features.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.shiv.demo.R
import com.shiv.demo.base.BaseFragment
import com.shiv.demo.data.local.sharedPreference.SharedPreferenceKey
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    private val mSplashViewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(500)
            moveToNextScreen()
        }
    }

    private suspend fun moveToNextScreen() {
        mSplashViewModel.appPreference.getValueFlow(SharedPreferenceKey.login_status, false)
            .catch { }
            .collect { isLoggedIn ->
                if (isLoggedIn.not()) {
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                } else {
                    findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                }
            }
    }
}