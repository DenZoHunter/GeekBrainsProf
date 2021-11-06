package com.example.geegbrainsprofessional.domain.entity

sealed class AppState<T> {
    data class Success<T>(val data: T) : AppState<T>()
    data class Error<T>(val error: Throwable) : AppState<T>()
}