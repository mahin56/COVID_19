package com.android.covid_19.utils

object Urls {
    const val baisurl="https://api.covid19api.com"
    const val bycountry="/country"
    const val bypakistan=bycountry+"/pakistan"
    const val bypakistanwithstatus=bypakistan+"/status"
    const val bypakistanwithstatusconfirmed=bypakistanwithstatus+"/confirmed"
    const val bypakistanwithstatusrecovered=bypakistanwithstatus+"/recovered"
    const val bypakistanwithstatusdeathes=bypakistanwithstatus+"/deaths"
}