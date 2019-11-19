package com.mufeng.paging_with_network_demo.db.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mufeng.paging_with_network_demo.db.Blog

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/19 14:03
 * @描述
 */
@Dao
interface BlogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBlog(blog: Blog)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBlog(blogs: List<Blog>)

    @Query("SELECT * FROM table_blog")
    fun getBlogs(): DataSource.Factory<Int, Blog>

    @Query("DELETE FROM table_blog")
    fun clearData()

    @Query("SELECT COUNT(*) FROM table_blog ORDER BY id")
    fun getTotalNum(): Int

}