package com.example.taobaounion.uitls

import androidx.fragment.app.Fragment
import com.example.taobaounion.ui.fragment.HomeFragment
import com.example.taobaounion.ui.fragment.RedPacketFragment
import com.example.taobaounion.ui.fragment.SearchFragment
import com.example.taobaounion.ui.fragment.SelectedFragment

class FragmentCreator {
    companion object {
        const val INDEX_HOMEPAGE = 1
        const val INDEX_RED_PACKET = 2
        const val INDEX_SELECTED = 3
        const val INDEX_SEARCH = 4

        private val homeFragment: HomeFragment by lazy {
            HomeFragment()
        }
        private val redPacketFragment: RedPacketFragment by lazy {
            RedPacketFragment()
        }
        private val selectedFragment: SelectedFragment by lazy {
            SelectedFragment()
        }
        private val searchFragment: SearchFragment by lazy {
            SearchFragment()
        }

        fun getFragment(index: Int): Fragment? {
            when (index) {
                INDEX_HOMEPAGE -> return homeFragment

                INDEX_RED_PACKET -> return redPacketFragment

                INDEX_SELECTED -> return selectedFragment

                INDEX_SEARCH -> return searchFragment
            }
            return null
        }
    }
}