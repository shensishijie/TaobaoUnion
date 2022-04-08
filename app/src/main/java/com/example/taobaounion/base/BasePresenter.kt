package com.example.taobaounion.base

import com.example.taobaounion.uitls.RetrofitManager


open class BasePresenter<C> {
    protected val callbacks = ArrayList<C>()

    fun registerCallback(callback: C) {
        if (!callbacks.contains(callback)) {
            callbacks.add(callback)
        }
    }

    fun unRegisterCallback(callback: C) {
        callbacks.remove(callback)
    }

    protected val mApi by lazy {
        RetrofitManager.instance?.getApi()
    }

    open fun reload(){

    }

}