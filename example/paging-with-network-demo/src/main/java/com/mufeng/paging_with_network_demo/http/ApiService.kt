package com.mufeng.paging_with_network_demo.http

import com.mufeng.paging_with_network_demo.db.Article
import com.mufeng.paging_with_network_demo.db.BaseBean
import com.mufeng.paging_with_network_demo.db.PageBean
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author MuFeng-T
 * @createTime 2019-10-17
 * @details
 */
interface ApiService {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com"
    }

    /**
     * 获取首页文章列表
     * @param page Int
     * @return BaseBean<List<Article>>
     */
    @GET("/article/list/{page}/json")
    suspend fun getHomeArticles(@Path("page") page: Int): BaseBean<PageBean<Article>>
}