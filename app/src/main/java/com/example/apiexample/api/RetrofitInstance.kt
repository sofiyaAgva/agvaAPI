package com.example.apiexample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: HospitalApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://172.23.100.128:8000/hospital/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HospitalApi::class.java)
    }

//    val deviceApi: HospitalDeviceApi by lazy {
//        Retrofit.Builder()
//            .baseUrl("http://172.23.100.128:8000/api/logger/logs/Allevents/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(HospitalDeviceApi::class.java)
//    }

    val deviceApi: HospitalDeviceApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://172.23.100.128:8000/api/logger/logs/Allevents/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HospitalDeviceApi::class.java)
    }
}