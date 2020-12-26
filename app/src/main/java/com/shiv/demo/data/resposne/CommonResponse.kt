package com.shiv.demo.data.resposne

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class UserListResponse(
    @SerializedName("data")
    val data: List<UserData>?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?
)

@Entity(tableName = "user_data")
data class UserData(
    @SerializedName("avatar")
    val avatar: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("id")
    @PrimaryKey val id: Int?,
    @SerializedName("last_name")
    val lastName: String?
)

data class LoginResponse(
    @SerializedName("token")
    val token: String?,
    @SerializedName("error")
    val error: String?
)