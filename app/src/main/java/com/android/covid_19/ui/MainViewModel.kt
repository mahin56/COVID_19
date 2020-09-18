package com.android.covid_19.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.covid_19.model.COVIDcases
import com.android.covid_19.retrofit.COVIDAPI
import com.android.covid_19.retrofit.retrofitclintinstance
import retrofit2.*
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel:ViewModel() {
    private  val COVIDcasesLIveData : MutableLiveData<List<COVIDcases>> = MutableLiveData()
    fun get(fromdateandtime: Calendar, todateandtime: Calendar):LiveData<List<COVIDcases>>{
      val sdf = SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss'Z'")
        val fromgmt :String = sdf.format(fromdateandtime.time)
        val togmt :String = sdf.format(todateandtime.time)
        var  covidapi: COVIDAPI= retrofitclintinstance
          .getretrofitInstance()
          .create(COVIDAPI::class.java)
        val call:  Call<List<COVIDcases>> = covidapi.getallcases(fromgmt,togmt)
        call.enqueue(object :Callback<List<COVIDcases>>{
            override fun onResponse(
                call: Call<List<COVIDcases>>,
                response: Response<List<COVIDcases>>
            ) {
            COVIDcasesLIveData.value=response.body()
            }

            override fun onFailure(call: Call<List<COVIDcases>>, t: Throwable) {
            }
        })
        return  COVIDcasesLIveData
    }
}