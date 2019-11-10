package com.mufeng.fragmentlazydemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/10 17:52
 * @描述
 */
abstract class BaseFragment : Fragment(){

    abstract val layoutId: Int
    protected var isDataInitiated: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
    }

    abstract fun initView(savedInstanceState: Bundle?)

    override fun onResume() {
        super.onResume()
        if (!isDataInitiated) {
            lazyLoadData()
            isDataInitiated = true
        }
    }

    abstract fun lazyLoadData()

    fun refreshData(){
        isDataInitiated = false
    }
}