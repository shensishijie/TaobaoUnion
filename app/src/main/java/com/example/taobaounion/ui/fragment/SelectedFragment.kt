package com.example.taobaounion.ui.fragment

import android.view.View
import com.example.taobaounion.R
import com.example.taobaounion.base.BaseFragment
import com.example.taobaounion.presenter.impl.SelectedPagePresenterImpl

class SelectedFragment : BaseFragment<SelectedPagePresenterImpl>() {
    override fun getSubPresenter(): SelectedPagePresenterImpl? {
        return SelectedPagePresenterImpl()
    }

    override fun getOnRetryListener(): View.OnClickListener? {
        return View.OnClickListener {

        }
    }

    override fun getPageLayoutId(): Int {
        return R.layout.fragment_selected
    }

}