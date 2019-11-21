package com.mufeng.roomdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.mufeng.mvvmlib.ext.loge
import com.mufeng.roomdemo.db.AppDatabase
import com.mufeng.roomdemo.db.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/21 10:41
 * @描述
 */
class MainViewModel : ViewModel(){

    private val userDao by lazy { AppDatabase.get().uerDao() }
    val data = userDao.getUsers().toLiveData(pageSize = 20, boundaryCallback = object : PagedList.BoundaryCallback<User>(){
        override fun onItemAtEndLoaded(itemAtEnd: User) {
            loge { "没有更多数据" }
        }

        override fun onZeroItemsLoaded() {
            loge { "没有查询出数据" }
        }
    })

    fun insert(user: User) {
        viewModelScope.launch (Dispatchers.IO){
            userDao.insert(user)
        }
    }

    fun insert(users: List<User>) {
        viewModelScope.launch (Dispatchers.IO){
            userDao.insert(users)
        }
    }

    fun delete(user: User) {
        viewModelScope.launch (Dispatchers.IO){
            userDao.delete(user)
        }
    }

}