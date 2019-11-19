package com.mufeng.paging_with_network_demo.db.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mufeng.mvvmlib.ext.loge
import com.mufeng.paging_with_network_demo.app.App
import com.mufeng.paging_with_network_demo.db.Blog
import com.mufeng.paging_with_network_demo.db.dao.BlogDao

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/19 14:07
 * @描述
 */
@Database(entities = [Blog::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun blogDao(): BlogDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun get(): AppDatabase {
            if (INSTANCE == null) {
               INSTANCE = Room.databaseBuilder(
                   App.CONTEXT.applicationContext,
                   AppDatabase::class.java,
                    "BlogDatabase")
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            loge { "数据库创建" }
                        }
                    })
                   .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }
    }

}