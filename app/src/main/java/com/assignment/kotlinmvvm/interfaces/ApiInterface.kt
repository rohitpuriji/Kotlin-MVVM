package com.assignment.kotlinmvvm.interfaces

import com.assignment.kotlinmvvm.DataModel.Android
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("android")
    fun getAndroid(): Call<List<Android>>

}