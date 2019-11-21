package com.mufeng.roomdemo

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.mufeng.roomdemo.db.Tag
import com.mufeng.roomdemo.db.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = MyAdapter(viewModel)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.data.observe(this){
            adapter.submitList(it)
        }

    }

    fun saveOne(view: View) {
        val user = User(
            id = 1,
            name = "saveOne",
            age = 15,
            tags = arrayListOf(Tag(name = "saveOne_标签"))
        )
        viewModel.insert(user)
    }
    fun saveList(view: View) {

        val users = arrayListOf<User>()
        
        var user = User(
            id = 2,
            name = "saveList_2",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_2_标签"))
        )
        users.add(user)

        user = User(
            id = 3,
            name = "saveList_3",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_3_标签"))
        )
        users.add(user)

        user = User(
            id = 4,
            name = "saveList_4",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_4_标签"))
        )
        users.add(user)

        user = User(
            id = 5,
            name = "saveList_5",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_5_标签"))
        )
        users.add(user)

        user = User(
            id = 6,
            name = "saveList_6",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_6_标签"))
        )
        users.add(user)

        user = User(
            id = 7,
            name = "saveList_7",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_7_标签"))
        )
        users.add(user)

        user = User(
            id = 8,
            name = "saveList_8",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_8_标签"))
        )
        users.add(user)

        user = User(
            id = 9,
            name = "saveList_9",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_9_标签"))
        )
        users.add(user)

        user = User(
            id = 10,
            name = "saveList_10",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_10_标签"))
        )
        users.add(user)

        user = User(
            id = 11,
            name = "saveList_11",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_11_标签"))
        )
        users.add(user)

        user = User(
            id = 12,
            name = "saveList_12",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_12_标签"))
        )
        users.add(user)

        user = User(
            id = 13,
            name = "saveList_13",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_13_标签"))
        )
        users.add(user)

        user = User(
            id = 14,
            name = "saveList_14",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_14_标签"))
        )
        users.add(user)

        user = User(
            id = 15,
            name = "saveList_15",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_15_标签"))
        )
        users.add(user)

        user = User(
            id = 16,
            name = "saveList_16",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_16_标签"))
        )
        users.add(user)

        user = User(
            id = 17,
            name = "saveList_17",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_17_标签"))
        )
        users.add(user)

        user = User(
            id = 18,
            name = "saveList_18",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_18_标签"))
        )
        users.add(user)

        user = User(
            id = 19,
            name = "saveList_19",
            age = 15,
            tags = arrayListOf(Tag(name = "saveList_19_标签"))
        )
        users.add(user)
        viewModel.insert(users)
    }
    fun save(view: View) {
        
    }
}
