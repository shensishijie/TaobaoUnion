package com.example.taobaounion.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import butterknife.ButterKnife

abstract class BaseActivity<T> : AppCompatActivity() {

    protected var presenter: T? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        presenter = getSubPresenter()
        initView()
        initListener()
        bindData()
    }

    abstract fun getContentView(): Int


    abstract fun getSubPresenter(): T?

    override fun onDestroy() {
        super.onDestroy()
        release()
    }

    open fun release() {

    }

    open fun initView() {

    }

    open fun bindData() {

    }

    open fun initListener() {

    }

}