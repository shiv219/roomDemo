package com.shiv.demo.utils

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.shiv.demo.R
import com.shiv.demo.databinding.DialogNetworkErrorBinding
import com.shiv.demo.databinding.ProgressBarBinding

object CommonDialogs {
    fun createLoadingDialog(context: Context): Dialog {
        val mProgressAndErrorView =
            ProgressBarBinding.inflate(LayoutInflater.from(context))
        val dialog = Dialog(context)
        dialog.setContentView(mProgressAndErrorView.root)
        dialog.setCancelable(false)
        dialog.window?.apply {
            setBackgroundDrawableResource(android.R.color.transparent)
            ViewGroup.LayoutParams.MATCH_PARENT
            ViewGroup.LayoutParams.MATCH_PARENT
        }
        return dialog
    }

    fun createApiErrorDialog(context: Context, errorMessage: String, callBack: () -> Unit): Dialog {
        val mBinding =
            DialogNetworkErrorBinding.inflate(LayoutInflater.from(context))
        val dialog = Dialog(context, R.style.FullScreenDialog)

        dialog.setContentView(mBinding.root)
        dialog.setCancelable(true)
        mBinding.tvErrorMsz.text = errorMessage
        mBinding.tvOk.setOnClickListener {
            dialog.cancel()
        }
        dialog.window?.apply {
            setBackgroundDrawableResource(android.R.color.transparent)
            ViewGroup.LayoutParams.MATCH_PARENT
            ViewGroup.LayoutParams.MATCH_PARENT
        }
        dialog.setOnDismissListener {
            callBack()
        }
        return dialog

    }
}
