package com.example.apiexample.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class HospitalModel(
    @SerializedName("data")
    var HospitalModelData: ArrayList<Data?>? = arrayListOf(),
    @SerializedName("message")
    var HospitalModelMessage: String? = "",
    @SerializedName("statusCode")
    var HospitalModelStatusCode: Int? = 0,
    @SerializedName("statusValue")
    var HospitalModelStatusValue: String? = ""
)

    @Serializable
    class Data(
        @SerializedName("City")
        var HospitalModelCity: String? = "",
        @SerializedName("Country")
        var HospitalModelCountry: String? = "",
        @SerializedName("District")
        var HospitalModelDistrict: String? = "",
        @SerializedName("Hospital_Address")
        var HospitalModelHospitalAddress: String? = "",
        @SerializedName("Hospital_Name")
        var HospitalModelHospitalName: String? = "",
        @SerializedName("_id")
        var HospitalModelId: String? = "",
        @SerializedName("Pincode")
        var HospitalModelPincode: String? = "",
        @SerializedName("State")
        var HospitalModelState: String? = ""
    )

