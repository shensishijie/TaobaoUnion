package com.example.taobaounion.base

interface IBaseViewCallback {

    /**
     * 加载中、网络错误、数据为空的回调
     */
    fun onLoading()

    fun onError()

    fun onEmpty()
}