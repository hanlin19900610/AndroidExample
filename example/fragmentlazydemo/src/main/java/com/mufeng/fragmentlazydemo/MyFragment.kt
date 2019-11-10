package com.mufeng.fragmentlazydemo

import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/10 13:38
 * @描述
 */
class MyFragment : BaseFragment(){
    override val layoutId: Int
        get() = R.layout.fragment_home

    companion object {
        fun getInstance(content: String): MyFragment{
            val fragment = MyFragment()
            val bundle = Bundle()
            bundle.putString("content", content)
            fragment.arguments = bundle
            return fragment
        }
    }

    private var content: String? = ""


    override fun initView(savedInstanceState: Bundle?) {
        content = arguments?.getString("content")
        tvContent.text = content
    }

    override fun lazyLoadData() {
        Log.e("TAG", "$content == 进行数据加载")
    }
}