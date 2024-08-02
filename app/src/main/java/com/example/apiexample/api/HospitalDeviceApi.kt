package com.example.apiexample.api

import com.example.apiexample.model.DeviceModel
import com.example.apiexample.model.HospitalModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HospitalDeviceApi {

    @GET("Events")
     suspend fun getHospitalDevice(
         @Header("Authorization") token: String,
         @Query("search") search: String
     ) : Response<DeviceModel>
}