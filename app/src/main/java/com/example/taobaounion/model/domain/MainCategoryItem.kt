package com.example.taobaounion.model.domain

data class MainCategoryItem(
    val success: Boolean,
    val code: Int,
    val message:String,
    val data: List<Data>
    ) {
    data class Data (
        val id: Int,
        val title: String
        )
    }
