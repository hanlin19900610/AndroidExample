package com.mufeng.paging_with_network_demo.db

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/19 11:33
 * @描述
 */
@JsonClass(generateAdapter = true)
class BaseBean<out T>(
    @Json(name = "data")
    val data: T? = null,
    @Json(name = "errorCode")
    val errorCode: Int? = 0,
    @Json(name = "errorMsg")
    val errorMsg: String? = ""
)