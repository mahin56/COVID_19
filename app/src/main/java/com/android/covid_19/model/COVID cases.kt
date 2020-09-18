package com.android.covid_19.model

import com.google.gson.annotations.SerializedName

data class COVIDcases(@SerializedName("Cases") var cases:Int, @SerializedName("Status") var status:String)
