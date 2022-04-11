package com.example.taobaounion.ui.fragment

import android.view.View
import com.example.taobaounion.R
import com.example.taobaounion.base.BaseFragment
import com.example.taobaounion.presenter.impl.SearchPagePresenterImpl

class SearchFragment : BaseFragment<SearchPagePresenterImpl>() {
    override fun getSubPresenter(): SearchPagePresenterImpl? {
        return SearchPagePresenterImpl()
    }

    override fun getOnRetryListener(): View.OnClickListener? {
        return View.OnClickListener {

        }
    }

    override fun getPageLayoutId(): Int {
        return R.layout.fragment_search
    }

}