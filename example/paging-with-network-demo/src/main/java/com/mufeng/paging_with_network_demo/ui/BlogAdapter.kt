package com.mufeng.paging_with_network_demo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mufeng.paging_with_network_demo.databinding.ItemBlogBinding
import com.mufeng.paging_with_network_demo.db.Blog

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/19 13:47
 * @描述
 */
class BlogAdapter(val viewModel: MainViewModel) : PagedListAdapter<Blog, BlogAdapter.BlogViewHolder>(diffCallBack){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val itemBinding = ItemBlogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BlogViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<Blog>(){
            override fun areItemsTheSame(oldItem: Blog, newItem: Blog): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Blog, newItem: Blog): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class BlogViewHolder(private val binding: ItemBlogBinding): RecyclerView.ViewHolder(binding.root){
        fun bindTo(blog: Blog?) {
            binding.blog = blog
            binding.viewModel = viewModel
        }
    }

}