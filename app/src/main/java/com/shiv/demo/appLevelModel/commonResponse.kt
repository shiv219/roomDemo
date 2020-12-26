package com.shiv.demo.appLevelModel

import com.google.gson.annotations.SerializedName


data class NetworkResponse<T>(
    @SerializedName("authStatus")
    val authStatus: String?,
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val data: T?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String?
) {

    val isSuccessful: Boolean
        get() = code in 200..300

    val isFailure: Boolean = status == "success"
}


