package com.android.covid_19.retrofit

import com.android.covid_19.model.COVIDcases
import com.android.covid_19.utils.Urls
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface COVIDAPI {
    @GET(Urls.bypakistanwithstatusconfirmed)
    fun getallcases(@Query("from") time: String, @Query("to") time1: String): Call<List<COVIDcases>>
}