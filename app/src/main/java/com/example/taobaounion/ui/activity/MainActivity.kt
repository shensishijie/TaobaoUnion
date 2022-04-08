package com.example.taobaounion.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.taobaounion.R
import com.example.taobaounion.base.BaseActivity
import com.example.taobaounion.base.BaseFragment
import com.example.taobaounion.databinding.ActivityMainBinding
import com.example.taobaounion.ui.fragment.HomeFragment
import com.example.taobaounion.ui.fragment.RedPacketFragment
import com.example.taobaounion.ui.fragment.SearchFragment
import com.example.taobaounion.ui.fragment.SelectedFragment
import com.example.taobaounion.uitls.FragmentCreator
import com.example.taobaounion.uitls.LogUtils


class MainActivity : BaseActivity<Any, ActivityMainBinding>(), IActivityForFragment {



    //    private fun initListener() {

//        }

    //        binding.testNavigationBar.setOnCheckedChangeListener { group, checkedId ->
//            // LogUtils.d(TestActivity.class,"checkedId -- > " + checkedId);
//            when (checkedId) {
//                R.id.test_home -> Log.d("MainActivity", "切换到首页")
//                R.id.test_selected -> Log.d("MainActivity", "切换到精选")
//                R.id.test_search -> Log.d("MainActivity", "切换到搜索")
//                R.id.test_red_packet -> Log.d("MainActivity", "切换到特惠")
//            }
//        }
    override fun getSubPresenter(): Any? {
        return null
    }

    override fun initView() {
        val supportFragmentManager = supportFragmentManager
        val transaction = supportFragmentManager.beginTransaction()
        val homeFragment = FragmentCreator.getFragment(FragmentCreator.INDEX_HOMEPAGE)
        transaction.add(
            R.id.page_container,
            homeFragment!!,
            FragmentCreator.INDEX_HOMEPAGE.toString()
        )
        lastFragmentIndex = FragmentCreator.INDEX_HOMEPAGE
        //
        val redPacketFragment = FragmentCreator.getFragment(FragmentCreator.INDEX_RED_PACKET)
        transaction.add(
            R.id.page_container,
            redPacketFragment!!,
            FragmentCreator.INDEX_RED_PACKET.toString()
        )
        transaction.hide(redPacketFragment)
        //
        val selectFragment = FragmentCreator.getFragment(FragmentCreator.INDEX_SELECTED)
        transaction.add(
            R.id.page_container,
            selectFragment!!,
            FragmentCreator.INDEX_SELECTED.toString()
        )
        transaction.hide(selectFragment)
        //
        val searchFragment = FragmentCreator.getFragment(FragmentCreator.INDEX_SEARCH)
        transaction.add(
            R.id.page_container,
            searchFragment!!,
            FragmentCreator.INDEX_SEARCH.toString()
        )
        transaction.hide(searchFragment)
        transaction.commit()
    }

    override fun initListener() {
        super.initListener()
        binding.mainNavigationBar.setOnNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.home -> {
                    LogUtils.d(this, "initListener: 切换到首页")
                    setUpFragment(FragmentCreator.INDEX_HOMEPAGE,null)
                }

                R.id.red_packet -> {
                    LogUtils.d(this, "initListener: 切换到特惠")
                    setUpFragment(FragmentCreator.INDEX_RED_PACKET,null)                }

                R.id.selected -> {
                    LogUtils.d(this, "initListener: 切换到精选")
                    setUpFragment(FragmentCreator.INDEX_SELECTED,null)                }

                R.id.search -> {
                    LogUtils.d(this, "initListener: 切换到搜索")
                    setUpFragment(FragmentCreator.INDEX_SEARCH,null)                }
            }
            true
        }
    }

    private var lastFragmentIndex = -1;

    override fun setUpFragment(index: Int, bundle: Bundle?) {
        if (index == lastFragmentIndex) {
            return
        }
        val fragment = FragmentCreator.getFragment(index)
        fragment?.arguments = bundle
        if (fragment != null) {
            val supportFragmentManager = supportFragmentManager
            val transaction = supportFragmentManager.beginTransaction()
            if (lastFragmentIndex != -1) {
                val lastFragment = FragmentCreator.getFragment(lastFragmentIndex)
                transaction.hide(lastFragment!!)
            }
            if (!fragment.isAdded) {
                transaction.add(R.id.page_container, fragment, index.toString())
            } else {
                transaction.show(fragment)
            }
            lastFragmentIndex = index
            transaction.commit()
        }
        //updateNavigationCheckedByPosition(index)
    }

    private fun updateNavigationCheckedByPosition(index: Int) {

    }

}
