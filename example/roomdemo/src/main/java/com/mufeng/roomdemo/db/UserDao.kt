package com.mufeng.roomdemo.db

import androidx.paging.DataSource
import androidx.room.*

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/21 10:17
 * @描述
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<User>)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user")
    fun getUsers(): DataSource.Factory<Int, User>

}