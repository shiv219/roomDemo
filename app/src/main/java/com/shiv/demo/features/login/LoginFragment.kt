package com.shiv.demo.features.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.shiv.demo.R
import com.shiv.demo.base.BaseFragment
import com.shiv.demo.data.local.sharedPreference.SharedPreferenceKey
import com.shiv.demo.databinding.FragmentLoginBinding
import com.shiv.demo.ext.isValidEmail
import com.shiv.demo.ext.setPasswordView
import com.shiv.demo.ext.showToast
import com.shiv.demo.ext.toAppError
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val mLoginViewModel: LoginViewModel by viewModels()

    private lateinit var mBinding: FragmentLoginBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = FragmentLoginBinding.bind(view)
        mBinding.onClickListener = this
        mBinding.lifecycleOwner = viewLifecycleOwner
        mBinding.mLoginViewMOdel = mLoginViewModel
        viewPassword()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvSubmit -> {
                isCredentialsValid()
            }
        }
    }

    private fun viewPassword() {
        mBinding.tilPassword.setEndIconOnClickListener {
            mBinding.etPassword.setPasswordView { isEnabled ->
                if (isEnabled) {
                    tilPassword.setEndIconDrawable(R.drawable.ic_eye_hide)
                    mLoginViewModel.isPasswordViewEnabled.value = true
                } else {
                    mLoginViewModel.isPasswordViewEnabled.value = false
                    tilPassword.setEndIconDrawable(R.drawable.ic_eye)
                }
            }
        }
    }

    private fun isCredentialsValid() {
        mLoginViewModel.run {
            mBinding.run {
                when {
                    request.value!!.email.isValidEmail().not() -> {
                        commonUtils.setErrorNull(
                            tilEmail,
                            getString(R.string.enter_valid_email),
                            null
                        )
                    }
                    request.value!!.password.isEmpty() -> {
                        commonUtils.setErrorNull(
                            tilPassword,
                            getString(R.string.field_cant_be_empty),
                            arrayOf(tilEmail)
                        )
                    }
                    else -> {
                        commonUtils.setErrorNull(null, "", arrayOf(tilEmail, tilPassword))
                        doLogin()
                    }
                }
            }
        }
    }

    private fun doLogin() {
        lifecycleScope.launch {
            mLoginViewModel.login.collect { loadState ->
                showLoading(loadState.isLoading)
                loadState.getErrorIfExists().toAppError()?.let { appError ->
                    onError(appError)
                }
                loadState.getValueOrNull()?.let { response ->
                    response.token?.let {
                        mLoginViewModel.appPreference.setValue(
                            SharedPreferenceKey.login_status,
                            true
                        )
                        mLoginViewModel.appPreference.setValue(
                            SharedPreferenceKey.user_access_token,
                            it
                        )
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    }
                    response.error?.let {
                        requireActivity().showToast(it)
                    }
                }
            }
        }
    }
}