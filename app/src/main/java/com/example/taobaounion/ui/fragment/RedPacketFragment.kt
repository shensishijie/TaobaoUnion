package com.example.taobaounion.ui.fragment

import android.view.View
import com.example.taobaounion.R
import com.example.taobaounion.base.BaseFragment
import com.example.taobaounion.presenter.impl.RedPacketPagePresenterImpl

class RedPacketFragment : BaseFragment<RedPacketPagePresenterImpl>(){

    override fun getSubPresenter(): RedPacketPagePresenterImpl? {
        return RedPacketPagePresenterImpl()
    }

    override fun getOnRetryListener(): View.OnClickListener? {
        return View.OnClickListener {

        }
    }

    override fun getPageLayoutId(): Int {
        return R.layout.fragment_red_packet
    }
}