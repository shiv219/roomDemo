package com.shiv.demo.data.repository

import androidx.paging.PagingData
import com.shiv.demo.data.resposne.LoginRequest
import com.shiv.demo.data.resposne.LoginResponse
import com.shiv.demo.data.resposne.UserData
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    fun getUserData(): Flow<PagingData<UserData>>

    fun login(body: LoginRequest): Flow<LoginResponse>
}