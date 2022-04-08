package com.example.taobaounion.base

import android.app.Application
import android.content.Context

class BaseApplication : Application() {
    companion object {
        var appContext: Context? = null
        fun getContext(): Context {
            return appContext!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        appContext = baseContext
    }
}