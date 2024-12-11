package com.hayde117.retrofitdemo.utils

//
data class UiState (
    val isLoading: Boolean = false,
    val error: Error? = null,
    val items: List<String> = listOf()
){
    sealed class Error {
        object NetworkError: Error()
        object InputTooShort: Error()
        object InputEmpty: Error()
    }
}

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : NetworkResult<T>(data)

    class Error<T>(message: String?, data: T? = null) : NetworkResult<T>(data, message)

    class Loading<T> : NetworkResult<T>()

}