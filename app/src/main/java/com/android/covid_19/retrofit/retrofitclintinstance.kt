package com.android.covid_19.retrofit

import com.android.covid_19.utils.Urls
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofitclintinstance {
    lateinit var retrofit: Retrofit
    fun getretrofitInstance(): Retrofit{
        retrofit = Retrofit.Builder()
            .baseUrl(Urls.baisurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}