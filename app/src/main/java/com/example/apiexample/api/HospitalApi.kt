package com.example.apiexample.api

import com.example.apiexample.model.HospitalModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


//token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiNjU5YmI1ZmExMjU2MzNjYmNjNzNlZjkyIiwianRpIjoiMVJ3VGhKSlRQaSIsImlhdCI6MTcyMjUxMzAyNCwiZXhwIjoxNzIzODA5MDI0fQ.Q7aweMvcnjyaeHU_J0OgUMGvRvcni2llYD21G_4LNHw
interface HospitalApi {
    @GET("hospital-list")

    suspend fun getHospitals() : Response<HospitalModel>
}