package com.shiv.demo.data.local.sharedPreference

import androidx.datastore.preferences.core.preferencesKey

object SharedPreferenceKey {
    val login_status = preferencesKey<Boolean>("login_status")
    val user_access_token = preferencesKey<String>("user_access_token")
    val user_id = preferencesKey<String>("user_id")
    val userCount = preferencesKey<String>("user_count")
}