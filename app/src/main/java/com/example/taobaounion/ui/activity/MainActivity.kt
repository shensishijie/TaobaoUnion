package com.example.taobaounion.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.example.taobaounion.R
import com.example.taobaounion.base.BaseFragment
import com.example.taobaounion.databinding.ActivityMainBinding
import com.example.taobaounion.ui.fragment.HomeFragment
import com.example.taobaounion.ui.fragment.RedPacketFragment
import com.example.taobaounion.ui.fragment.SearchFragment
import com.example.taobaounion.ui.fragment.SelectedFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //
    private lateinit var homeFragment: HomeFragment
    private lateinit var redPacketFragment: RedPacketFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var selectedFragment: SelectedFragment
    private lateinit var fragmentManager: FragmentManager
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragment()
        initListener()
    }

    private fun initListener() {
        binding.mainNavigationBar.setOnNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.home -> {
                    Log.d(TAG, "initListener: 切换到首页")
                    switchFragment(homeFragment)
                }

                R.id.red_packet -> {
                    Log.d(TAG, "initListener: 切换到特惠")
                    switchFragment(redPacketFragment)
                }

                R.id.selected -> {
                    Log.d(TAG, "initListener: 切换到精选")
                    switchFragment(selectedFragment)
                }

                R.id.search -> {
                    Log.d(TAG, "initListener: 切换到搜索")
                    switchFragment(searchFragment)
                }
            }
            true
        }
    }

    private fun initFragment() {
        homeFragment = HomeFragment()
        redPacketFragment = RedPacketFragment()
        searchFragment = SearchFragment()
        selectedFragment = SelectedFragment()
        fragmentManager = supportFragmentManager
        switchFragment(homeFragment)
    }

    private fun switchFragment(targetFragment: BaseFragment) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_page_container, targetFragment)
        fragmentTransaction.commit()
    }
}