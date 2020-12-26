package com.shiv.demo.ext

import androidx.annotation.StringRes
import com.shiv.demo.R
import com.shiv.demo.appLevelModel.AppError
import kotlinx.coroutines.TimeoutCancellationException
import retrofit2.HttpException

fun Throwable?.toAppError(): AppError? {
    return when (this) {
        null -> null
        is AppError -> this
        is HttpException->{

          AppError.ApiException.InvalidDataException(NetworkInvalidDataException( response()?.errorBody()?.string()?:""))
        }
        is TimeoutCancellationException -> AppError.ApiException.NetworkException(this)
        else -> AppError.UnknownException(this)
    }
}
@StringRes
fun AppError.stringRes() = when (this) {
    is AppError.ApiException.NetworkException -> R.string.check_internet_connection
//    is AppError.ApiException.ServerException -> R.string.error_server
//    is AppError.ApiException.SessionNotFoundException -> R.string.error_unknown
//    is AppError.ApiException.UnknownException -> R.string.error_unknown
//    is AppError.UnknownException -> R.string.error_unknown
    else -> R.string.something_went_wrong
}

class NetworkInvalidDataException(private val errorMessage:String):Throwable(errorMessage)