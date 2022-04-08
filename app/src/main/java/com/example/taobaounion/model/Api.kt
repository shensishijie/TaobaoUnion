package com.example.taobaounion.model

import com.example.taobaounion.model.domain.MainCategoryItem
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("discovery/categories")
    fun getCategories(): Call<MainCategoryItem>
}