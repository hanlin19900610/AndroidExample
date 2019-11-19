package com.mufeng.paging_with_network_demo.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/19 10:50
 * @描述
 */
@Entity(tableName = "table_blog")
data class Blog(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)

fun List<Article>.asBlog(): List<Blog>{
    val blogs = arrayListOf<Blog>()
    forEach {
        val blog = Blog(it.id?:0, it.title?:"")
        blogs.add(blog)
    }
    return blogs
}