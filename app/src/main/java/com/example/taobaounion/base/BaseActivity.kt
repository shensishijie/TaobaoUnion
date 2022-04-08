package com.example.taobaounion.base

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<T, VB : ViewBinding> : AppCompatActivity() {

    protected var presenter: T? = null

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val clazz = type.actualTypeArguments[0] as Class<VB>
            val method = clazz.getMethod("inflate", LayoutInflater::class.java)
            binding = method.invoke(null, layoutInflater) as VB
            setContentView(binding.root)
        }
        presenter = getSubPresenter()
        initView()
        initListener()
        bindData()
    }

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