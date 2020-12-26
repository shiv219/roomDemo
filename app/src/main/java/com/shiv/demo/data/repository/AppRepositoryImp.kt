package com.shiv.demo.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.shiv.demo.data.local.db.AppDatabase
import com.shiv.demo.data.local.sharedPreference.AppPreferences
import com.shiv.demo.data.network.ApiService
import com.shiv.demo.data.resposne.LoginRequest
import com.shiv.demo.data.resposne.LoginResponse
import com.shiv.demo.data.resposne.UserData
import com.shiv.demo.ext.bodyOrThrow
import com.shiv.demo.features.home.paging.pagingSource.UserRemoteMediator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalPagingApi
@Singleton
class AppRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val database: AppDatabase,
    private val appPreferences: AppPreferences
) : AppRepository {
    override fun getUserData(): Flow<PagingData<UserData>> {
        val pagingSourceFactory = { database.usersDao().fetchUserList() }

        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = UserRemoteMediator(
                apiService,
                database, appPreferences
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun login(body: LoginRequest): Flow<LoginResponse> = flow {
        emit(apiService.login(body).execute().bodyOrThrow())
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 6
    }
}