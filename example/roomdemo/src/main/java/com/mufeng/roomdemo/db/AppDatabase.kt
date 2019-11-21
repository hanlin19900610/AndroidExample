package com.mufeng.roomdemo.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mufeng.mvvmlib.ext.loge
import com.mufeng.roomdemo.App

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/21 10:22
 * @描述
 */
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun uerDao(): UserDao

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