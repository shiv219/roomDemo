package com.shiv.demo.base

import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment
import com.shiv.demo.R
import com.shiv.demo.appLevelModel.AppError
import com.shiv.demo.ext.showToast
import com.shiv.demo.ext.showToastRes
import com.shiv.demo.ext.stringRes
import com.shiv.demo.utils.CommonDialogs


abstract class BaseFragment(id: Int) : Fragment(id), View.OnClickListener {

    private var loadingDialog: Dialog? = null
    private var networkErrorDialog: Dialog? = null

    override fun onClick(v: View?) {
        //empty overriden method
    }

    fun showLoading(isLoading: Boolean = true) {
        if (isLoading) {
            if (loadingDialog == null)
                loadingDialog = CommonDialogs.createLoadingDialog(requireContext())
            if (loadingDialog?.isShowing?.not()!!)
                loadingDialog?.show()
        } else {
            hideLoading()
        }
    }

   private fun showNetworkErrorDialog(
        message: String = getString(R.string.check_internet_connection),
        callback: () -> Unit
    ) {
        networkErrorDialog = null
        if (networkErrorDialog == null)
            networkErrorDialog = CommonDialogs.createApiErrorDialog(requireContext(), message) {
                callback()
            }
        if (networkErrorDialog?.isShowing?.not()!!) {
            networkErrorDialog?.show()
        }
    }

    private fun hideLoading() {
        if (loadingDialog?.isShowing == true)
            loadingDialog?.cancel()
    }

    open fun onBackPressed() {
        requireActivity().onBackPressed()
    }

    fun onError(stringRes: AppError) {
        when (stringRes) {
            is AppError.ApiException.InvalidDataException -> {
                stringRes.cause?.message?.let {
                    requireActivity().showToast(it)
                }
            }
            else -> {
                requireActivity().showToastRes(stringRes.stringRes())
            }
        }
    }
}