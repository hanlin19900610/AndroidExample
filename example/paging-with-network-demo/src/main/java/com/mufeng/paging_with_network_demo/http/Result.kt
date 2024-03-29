package com.mufeng.paging_with_network_demo.http

/**
 * @author MuFeng-T
 * @createTime 2019-10-17
 * @details
 */
sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T?) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}
