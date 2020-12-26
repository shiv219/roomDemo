package com.shiv.demo.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import com.google.android.material.textfield.TextInputLayout
import javax.inject.Inject


class CommonUtils @Inject constructor() {

    fun setErrorNull(
        errorView: TextInputLayout?,
        errorMessage: String,
        nullErrorView: Array<TextInputLayout>?
    ) {
        errorView?.error = errorMessage
        nullErrorView?.forEach {
            it.error = null
        }
    }

    fun getScreenHeight(context: Context): Int {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        return dm.heightPixels
    }

    fun getScreenWidth(context: Context): Int {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        return dm.widthPixels
    }

}