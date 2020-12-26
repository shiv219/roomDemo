package com.shiv.demo.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shiv.demo.data.resposne.UserData

@Database(entities = [UserData::class,RemoteKeys::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun usersDao():UserDataDao
    abstract fun remoteKeysDao(): RemoteKeysDao

}