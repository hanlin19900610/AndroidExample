package com.mufeng.paging_with_network_demo.ui

import com.mufeng.paging_with_network_demo.db.Article
import com.mufeng.paging_with_network_demo.db.PageBean
import com.mufeng.paging_with_network_demo.http.BaseRepository
import com.mufeng.paging_with_network_demo.http.Result
import com.mufeng.paging_with_network_demo.http.WAHttpUtils

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/19 14:16
 * @描述
 */
class MainRepository : BaseRepository() {
    private val service by lazy { WAHttpUtils.service }

   suspend fun getBlogList(page: Int) : Result<PageBean<Article>> =
        executeResponse(service.getHomeArticles(page))
}