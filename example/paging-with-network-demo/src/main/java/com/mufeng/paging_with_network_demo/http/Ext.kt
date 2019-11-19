package com.mufeng.paging_with_network_demo.http

import com.mufeng.paging_with_network_demo.db.BaseBean


/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/14 14:19
 * @描述
 */

fun BaseBean<*>.isSuccess() = errorCode == 0

fun BaseBean<*>.isNotLogin() = errorCode == -1001

