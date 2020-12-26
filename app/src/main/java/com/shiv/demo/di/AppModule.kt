package com.shiv.demo.di

import android.content.Context
import androidx.room.Room
import com.shiv.demo.data.local.db.AppDatabase
import com.shiv.demo.data.local.db.RemoteKeysDao
import com.shiv.demo.data.local.db.UserDataDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun appDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "demo.db").build()
    }

    @Provides
    fun provideRemoteKeyDao(database: AppDatabase): RemoteKeysDao = database.remoteKeysDao()

    @Provides
    fun provideUserDao(database: AppDatabase): UserDataDao = database.usersDao()

}