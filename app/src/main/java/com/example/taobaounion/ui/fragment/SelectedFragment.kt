package com.example.taobaounion.ui.fragment

import android.view.View
import com.example.taobaounion.R
import com.example.taobaounion.base.BaseFragment
import com.example.taobaounion.presenter.impl.SelectedPagePresenterImpl

class SelectedFragment : BaseFragment<SelectedPagePresenterImpl>() {
    override fun getSubPresenter(): SelectedPagePresenterImpl? {
        TODO("Not yet implemented")
    }

    override fun getOnRetryListener(): View.OnClickListener? {
        TODO("Not yet implemented")
    }

    override fun getPageLayoutId(): Int {
        TODO("Not yet implemented")
    }

}