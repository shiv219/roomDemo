package com.shiv.demo.ext

import com.shiv.demo.appLevelModel.LoadState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*


@ExperimentalCoroutinesApi
fun <T> Flow<T>.toLoadingState(): Flow<LoadState<T>> {
    return map<T, LoadState<T>> {
        LoadState.Loaded(it)
    }
        .onStart {
            @Suppress("UNCHECKED_CAST")
            emit(LoadState.Loading as LoadState<T>)
        }.onEach { LoadState.Loading }
        .catch { e ->
            emit(LoadState.Error<T>(e))
        }
}