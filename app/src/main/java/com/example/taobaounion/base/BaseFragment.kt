package com.example.taobaounion.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taobaounion.R

abstract class BaseFragment<P> : Fragment() {

    enum class PageState {
        NONE, LOADING, ERROR, EMPTY, SUCCESS
    }

    protected var presenter: P? = null

    private var rootView: ViewGroup? = null

    abstract fun getSubPresenter(): P?


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        rootView = getRootView(inflater, container)
        val containerView = rootView?.findViewById<ViewGroup>(R.id.fragment_container)
        setUpView(rootView, containerView, inflater)
        presenter = getSubPresenter()
        bindEvent()
        loadData()
        return rootView
    }

    private var successView: View? = null
    private var loadingView: View? = null
    private var emptyView: View? = null
    private var errorView: View? = null

    private fun setUpView(
        rootView: ViewGroup?,
        container: ViewGroup?,
        inflater: LayoutInflater
    ) {
        successView = subSuccessView(inflater, container)
        container?.addView(successView)

        loadingView = createLoadingView(inflater, container)
        container?.addView(loadingView)
        //网络错误的View
        errorView = createErrorView(inflater, container)
        container?.addView(errorView)
        errorView?.setOnClickListener(getOnRetryListener())
        //数据为空的界面
        emptyView = createEmptyView(inflater, container)
        container?.addView(emptyView)

        switchUIByState(PageState.NONE)
        initView(successView!!)
    }

    private fun switchUIByState(state: PageState) {
        successView?.visibility = if (state == PageState.SUCCESS) View.VISIBLE else View.GONE
        loadingView?.visibility = if (state == PageState.LOADING) View.VISIBLE else View.GONE
        errorView?.visibility = if (state == PageState.ERROR) View.VISIBLE else View.GONE
        emptyView?.visibility = if (state == PageState.EMPTY) View.VISIBLE else View.GONE

        if (state == PageState.NONE) {
            successView?.visibility = View.GONE
            loadingView?.visibility = View.GONE
            errorView?.visibility = View.GONE
            emptyView?.visibility = View.GONE
        }
    }


    open fun getRootView(inflater: LayoutInflater,
                         container: ViewGroup?): ViewGroup? {
        return inflater.inflate(R.layout.fragment_container, container, false) as ViewGroup

    }

    abstract fun getOnRetryListener(): View.OnClickListener?

    open fun createEmptyView(inflater: LayoutInflater, rootView: ViewGroup?):View? {
        return inflater.inflate(R.layout.fragment_empty, rootView, false)
    }

    open fun createLoadingView(inflater: LayoutInflater, rootView: ViewGroup?):View? {
        return inflater.inflate(R.layout.fragment_loading, rootView, false)
    }

    open fun createErrorView(inflater: LayoutInflater, rootView: ViewGroup?):View? {
        return inflater.inflate(R.layout.fragment_error, rootView, false)
    }

    private fun subSuccessView(inflater: LayoutInflater, rootView: ViewGroup?):View? {
        return inflater.inflate(getPageLayoutId(), rootView, false)
    }

    abstract fun getPageLayoutId(): Int

    open fun loadData() {

    }

    open fun bindEvent() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        release()
    }

    open fun release() {

    }

    open fun initView(rootView: View) {

    }
}