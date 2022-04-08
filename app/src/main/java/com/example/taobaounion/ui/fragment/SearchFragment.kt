package com.example.taobaounion.ui.fragment

import android.view.View
import com.example.taobaounion.R
import com.example.taobaounion.base.BaseFragment
import com.example.taobaounion.presenter.impl.SearchPagePresenterImpl

class SearchFragment : BaseFragment<SearchPagePresenterImpl>() {
    override fun getSubPresenter(): SearchPagePresenterImpl? {
        TODO("Not yet implemented")
    }

    override fun getOnRetryListener(): View.OnClickListener? {
        TODO("Not yet implemented")
    }

    override fun getPageLayoutId(): Int {
        TODO("Not yet implemented")
    }

}