package com.shiv.demo.ext

import android.content.Context
import android.widget.Toast

fun Context.showToast(message:String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showToastRes(message:Int){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}