package com.example.taobaounion.base


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
}