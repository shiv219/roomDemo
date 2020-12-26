package com.shiv.demo.di

import androidx.paging.ExperimentalPagingApi
import com.shiv.demo.data.repository.AppRepository
import com.shiv.demo.data.repository.AppRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@ExperimentalPagingApi
@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun authenticationRepository(authenticationRepositoryImp: AppRepositoryImp): AppRepository
}