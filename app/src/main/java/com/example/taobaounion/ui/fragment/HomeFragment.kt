package com.example.taobaounion.ui.fragment

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.taobaounion.R
import com.example.taobaounion.base.BaseFragment
import com.example.taobaounion.databinding.FragmentHomeBinding
import com.example.taobaounion.presenter.impl.HomePagePresenterImpl

class HomeFragment : BaseFragment<HomePagePresenterImpl>() {

    private val binding: FragmentHomeBinding by viewBinding()

    override fun getSubPresenter(): HomePagePresenterImpl? {
        return HomePagePresenterImpl()
    }

    override fun getOnRetryListener(): View.OnClickListener? {
        return View.OnClickListener {

        }
    }

    override fun initView(rootView: View) {
        super.initView(rootView)
        switchUIByState(PageState.SUCCESS)
    }

    override fun getPageLayoutId(): Int {
        return R.layout.fragment_home
    }


}