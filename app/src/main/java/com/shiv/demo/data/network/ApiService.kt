package com.shiv.demo.data.network

import com.shiv.demo.data.resposne.LoginRequest
import com.shiv.demo.data.resposne.LoginResponse
import com.shiv.demo.data.resposne.UserListResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("/api/login")
    @Headers(Constant.HEADER_CONTENT_TYPE_JSON)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("/api/users")
    suspend fun getUsersList(
        @Query("page") pageCount: Int
    ): UserListResponse
}