package com.shiv.demo.data.local.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shiv.demo.data.resposne.UserData
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userList: List<UserData>)

    @Query("SELECT * FROM user_data")
    fun fetchUserList(): PagingSource<Int, UserData>

    @Query("SELECT * FROM user_data WHERE id = :userId ")
    fun fetchUser(userId: Int): Flow<UserData>

    @Query("DELETE FROM user_data")
    suspend fun clearRepo()

}