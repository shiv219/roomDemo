package com.shiv.demo.appLevelModel

interface ErrorGettable<T> {
    fun getErrorIfExists(): Throwable?
    fun getErrorResposne(): T?
}

sealed class LoadState<T> : ErrorGettable<T> {
    object Loading : LoadState<Nothing>()
    class Loaded<T>(val value: T) : LoadState<T>()
    class Error<T>(val e: Throwable) : LoadState<T>()
    class ErrorResponse<T>(val e: T) : LoadState<T>()


    val isLoading get() = this is Loading
    override fun getErrorIfExists() = if (this is Error) e else null
    override fun getErrorResposne() = if (this is ErrorResponse) e else null
    fun getValueOrNull(): T? = if (this is Loaded<T>) value else null
}

