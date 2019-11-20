package com.mufeng.paging_with_network_demo.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.mufeng.mvvmlib.basic.view.BaseVMActivity
import com.mufeng.paging_with_network_demo.R
import com.mufeng.paging_with_network_demo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseVMActivity<MainViewModel, ActivityMainBinding>() {
    private lateinit var adapter: BlogAdapter
    override val viewModel: MainViewModel by viewModels()
    override val layoutResId: Int = R.layout.activity_main
    private var page = 0
    override fun initView(savedInstanceState: Bundle?) {
        binding.viewModel = viewModel
        refreshLayout.setOnRefreshListener {
            page = 0
            viewModel.getBlogsWithRemote(page)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = BlogAdapter(viewModel)
        recyclerView.adapter = adapter
    }

    override fun initData() {
    }

    override fun startObserve() {
        super.startObserve()
        viewModel.blogLiveData.observe(this) {
            refreshLayout.isRefreshing = false
            adapter.submitList(it)
        }
    }

}
