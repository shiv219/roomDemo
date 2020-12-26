package com.shiv.demo.ext

import android.text.InputType
import android.view.View
import android.widget.EditText

fun EditText.setPasswordView(callBack: (isEnabled: Boolean) -> Unit) {
    if (inputType == InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD) {
        inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        setSelection(text?.length ?: 0)
        callBack(true)
    } else {
        callBack(false)
        inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        setSelection(text?.length ?: 0)
    }
}
fun toVisibility(constraint: Boolean): Int = if (constraint) {
    View.VISIBLE
} else {
    View.GONE
}