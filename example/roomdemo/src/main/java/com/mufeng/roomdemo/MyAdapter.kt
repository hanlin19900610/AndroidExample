package com.mufeng.roomdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mufeng.mvvmlib.ext.widget.clickWithTrigger
import com.mufeng.roomdemo.db.User
import org.jetbrains.anko.find

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/21 10:32
 * @描述
 */
class MyAdapter(val viewModel: MainViewModel) : PagedListAdapter<User, MyAdapter.MyViewHolder>(callback){
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }


    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvContent = itemView.find<TextView>(R.id.tvContent)

        fun bindTo(user: User?) {
            tvContent.text = user.toString()
            tvContent.clickWithTrigger {
                viewModel.delete(user!!)
            }
        }

    }

    companion object {
        private val callback = object : DiffUtil.ItemCallback<User>(){
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
               return oldItem == newItem
            }

        }
    }
}