package com.example.apiexample.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class DeviceModel(
    @SerializedName("currentPage")
    var HospitalModelCurrentPage: Int? = 0,
    @SerializedName("data")
    var HospitalModelData: Data? = Data(),
    @SerializedName("message")
    var HospitalModelMessage: String? = "",
    @SerializedName("status")
    var HospitalModelStatus: Int? = 0,
    @SerializedName("statusValue")
    var HospitalModelStatusValue: String? = "",
    @SerializedName("totalDataCount")
    var HospitalModelTotalDataCount: Int? = 0,
    @SerializedName("totalPages")
    var HospitalModelTotalPages: Int? = 0
) {
    @Serializable
    class Data(
        @SerializedName("data")
        var HospitalModelData: List<Data?>? = listOf()
    ) {
        @Serializable
        class Data(
            @SerializedName("addTofocus")
            var HospitalModelAddTofocus: Boolean? = false,
            @SerializedName("address")
            var HospitalModelAddress: String? = "",
            @SerializedName("alarmData")
            var HospitalModelAlarmData: List<AlarmData?>? = listOf(),
            @SerializedName("deviceId")
            var HospitalModelDeviceId: String? = "",
            @SerializedName("deviceInfo")
            var HospitalModelDeviceInfo: List<DeviceInfo?>? = listOf(),
            @SerializedName("health")
            var HospitalModelHealth: String? = "",
            @SerializedName("_id")
            var HospitalModelId: String? = "",
            @SerializedName("lastActive")
            var HospitalModelLastActive: String? = "",
            @SerializedName("last_hours")
            var HospitalModelLastHours: String? = "",
            @SerializedName("message")
            var HospitalModelMessage: String? = "",
            @SerializedName("patientData")
            var HospitalModelPatientData: List<Any?>? = listOf(),
            @SerializedName("total_hours")
            var HospitalModelTotalHours: String? = "",
            @SerializedName("updatedAt")
            var HospitalModelUpdatedAt: String? = ""
        ) {
            @Serializable
            class AlarmData(
                @SerializedName("ack")
                var HospitalModelAck: Ack? = Ack(),
                @SerializedName("createdAt")
                var HospitalModelCreatedAt: String? = "",
                @SerializedName("did")
                var HospitalModelDid: String? = "",
                @SerializedName("_id")
                var HospitalModelId: String? = "",
                @SerializedName("priority")
                var HospitalModelPriority: String? = "",
                @SerializedName("type")
                var HospitalModelType: String? = "",
                @SerializedName("updatedAt")
                var HospitalModelUpdatedAt: String? = "",
                @SerializedName("__v")
                var HospitalModelV: Int? = 0
            ) {
                @Serializable
                class Ack(
                    @SerializedName("code")
                    var HospitalModelCode: String? = "",
                    @SerializedName("date")
                    var HospitalModelDate: String? = "",
                    @SerializedName("msg")
                    var HospitalModelMsg: String? = ""
                )
            }

            @Serializable
            class DeviceInfo(
                @SerializedName("addTofocus")
                var HospitalModelAddTofocus: Boolean? = false,
                @SerializedName("Alias_Name")
                var HospitalModelAliasName: String? = "",
                @SerializedName("Bio_Med")
                var HospitalModelBioMed: String? = "",
                @SerializedName("Department_Name")
                var HospitalModelDepartmentName: String? = "",
                @SerializedName("DeviceId")
                var HospitalModelDeviceId: String? = "",
                @SerializedName("deviceType")
                var HospitalModelDeviceType: String? = "",
                @SerializedName("Doctor_Name")
                var HospitalModelDoctorName: String? = "",
                @SerializedName("Hospital_Name")
                var HospitalModelHospitalName: String? = "",
                @SerializedName("IMEI_NO")
                var HospitalModelIMEINO: String? = "",
                @SerializedName("_id")
                var HospitalModelId: String? = "",
                @SerializedName("isLocked")
                var HospitalModelIsLocked: Boolean? = false,
                @SerializedName("isPaymentDone")
                var HospitalModelIsPaymentDone: String? = "",
                @SerializedName("Ward_No")
                var HospitalModelWardNo: String? = ""
            )
        }
    }
}