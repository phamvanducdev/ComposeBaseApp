package com.ducpv.cba.core.data.network

/**
 * Created by pvduc9773 on 25/09/2023.
 */
import retrofit2.Response

sealed class ApiResponse<T> {
    companion object {
        fun <T> create(error: Throwable): ApiErrorResponse<T> {
            return ApiErrorResponse(
                error.message ?: "Unknown error",
                0,
            )
        }

        fun <T, R> create(response: Response<T>, combine: (T) -> R): ApiResponse<R> {
            return if (response.isSuccessful) {
                val body = response.body()
                val headers = response.headers()
                if (body == null || response.code() == 204) {
                    ApiEmptyResponse()
                } else {
                    ApiSuccessResponse(
                        combine(body),
                        headers,
                    )
                }
            } else {
                val msg = response.errorBody()?.string()
                val errorMsg = if (msg.isNullOrEmpty()) {
                    response.message()
                } else {
                    msg
                }
                ApiErrorResponse(
                    errorMsg ?: "Unknown error",
                    response.code(),
                )
            }
        }

        fun <T> ApiResponse<T>.body(): T? {
            return when (this) {
                is ApiEmptyResponse -> null
                is ApiErrorResponse -> throw Exception(this.errorMessage)
                is ApiSuccessResponse -> this.body
            }
        }
    }
}

/**
 * Separate class for HTTP 204 responses so that we can make ApiSuccessResponse's body non-null.
 */
class ApiEmptyResponse<T> : ApiResponse<T>()

data class ApiSuccessResponse<T>(
    val body: T?,
    val headers: okhttp3.Headers,
) : ApiResponse<T>()

data class ApiErrorResponse<T>(val errorMessage: String, val statusCode: Int) : ApiResponse<T>()