package com.example.taobaounion.view

import com.example.taobaounion.base.IBaseViewCallback
import com.example.taobaounion.model.domain.MainCategoryItem

interface IHomePageCallback : IBaseViewCallback {
    /**
     * 分类加载出来了
     */
    fun onCategoriesLoaded(result: MainCategoryItem?)
}