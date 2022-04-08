package com.example.taobaounion.uitls

import com.example.taobaounion.model.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager {
    private var retrofit: Retrofit? = null

    constructor() {
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }

    companion object {
        var instance: RetrofitManager? = null

        get() {
            if (field == null) {
                field = RetrofitManager()
            }
            return field
        }

        fun get(): RetrofitManager {
            return instance!!
        }
    }

    fun getApi(): Api {
        return retrofit?.create(Api::class.java)!!
    }
}