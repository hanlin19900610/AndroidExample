package com.mufeng.paging_with_network_demo.app

import com.mufeng.mvvmlib.basic.BaseApplication
import kotlin.properties.Delegates

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/10/16 21:18
 * @描述
 */
class App : BaseApplication(){
    companion object {
        var CONTEXT: App by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = this
    }
}