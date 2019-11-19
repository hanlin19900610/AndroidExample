package com.mufeng.paging_with_network_demo.db

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * PageBean
 * @param T
 * @property curPage Int?
 * @property datas List<T>?
 * @property offset Int?
 * @property over Boolean?
 * @property pageCount Int?
 * @property size Int?
 * @property total Int?
 * @constructor
 */
@JsonClass(generateAdapter = true)
class PageBean<T>(
    @Json(name = "curPage")
    val curPage: Int? = 1,
    @Json(name = "datas")
    val datas: List<T>? = emptyList(),
    @Json(name = "offset")
    val offset: Int? = 0,
    @Json(name = "over")
    val over: Boolean? = false,
    @Json(name = "pageCount")
    val pageCount: Int? = 0,
    @Json(name = "size")
    val size: Int? = 0,
    @Json(name = "total")
    val total: Int? = 0
)