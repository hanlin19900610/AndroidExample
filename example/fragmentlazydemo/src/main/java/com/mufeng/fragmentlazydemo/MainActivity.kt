package com.mufeng.fragmentlazydemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragments = arrayListOf<Fragment>()

        val fragment1 = MyFragment.getInstance("首页")
        val fragment2 = MyFragment.getInstance("消息")
        val fragment3 = MyFragment.getInstance("发现")
        val fragment4 = MyFragment.getInstance("我的")

        fragments.add(fragment1)
        fragments.add(fragment2)
        fragments.add(fragment3)
        fragments.add(fragment4)

        val adapter = BaseViewPagerAdapter(supportFragmentManager, fragments)
        viewPager.adapter = adapter

        refreshData.setOnClickListener {
            fragment2.refreshData()
        }

    }
}
