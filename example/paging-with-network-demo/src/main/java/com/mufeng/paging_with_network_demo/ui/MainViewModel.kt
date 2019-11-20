package com.mufeng.paging_with_network_demo.ui

import androidx.paging.Config
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.mufeng.mvvmlib.basic.BaseViewModel
import com.mufeng.mvvmlib.binding.BindingCommand2
import com.mufeng.paging_with_network_demo.db.Article
import com.mufeng.paging_with_network_demo.db.Blog
import com.mufeng.paging_with_network_demo.db.asBlog
import com.mufeng.paging_with_network_demo.db.database.AppDatabase
import com.mufeng.paging_with_network_demo.http.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/19 11:50
 * @描述
 */
class MainViewModel : BaseViewModel(){

    private val repository by lazy { MainRepository() }
    private val blogDao by lazy { AppDatabase.get().blogDao() }

    val blogLiveData = blogDao.getBlogs().toLiveData(
        Config(pageSize = 20),
        boundaryCallback = object : PagedList.BoundaryCallback<Blog>(){
            override fun onZeroItemsLoaded() {
                getBlogsWithRemote(0)
            }

            override fun onItemAtEndLoaded(itemAtEnd: Blog) {
                val nextPageIndex = (blogDao.getTotalNum() / 20) + 1
                getBlogsWithRemote(nextPageIndex)
            }
        }
    )

    fun getBlogsWithRemote(page: Int){
        launch {
            val response = withContext(Dispatchers.IO) {
                repository.getBlogList(page)
            }
            when (response){
                is Result.Success -> {
                    saveBlog(response.data?.datas)
                }
                is Result.Error -> {

                }
            }
        }
    }

    private fun saveBlog(datas: List<Article>?) {
        launch(Dispatchers.IO){
            if (datas.isNullOrEmpty()) {
                return@launch
            }
            blogDao.insertBlog(datas.asBlog())
        }
    }

    val itemClick = object : BindingCommand2<Blog, Int> {
        override fun apply(blog: Blog, position: Int) {
            toast("第${position}项的点击事件")
        }

    }

}