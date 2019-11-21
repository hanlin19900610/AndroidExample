package com.mufeng.roomdemo.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/21 9:58
 * @描述
 */
@Entity
@TypeConverters(TagConverters::class)
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val age: Int,
    val tags: List<Tag>
)