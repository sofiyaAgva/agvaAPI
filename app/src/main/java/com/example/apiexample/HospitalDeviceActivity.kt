package com.example.apiexample

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiexample.adapter.HospitalDeviceAdapter
import com.example.apiexample.adapter.HospitalItemAdapter
import com.example.apiexample.api.RetrofitInstance
import com.example.apiexample.databinding.ActivityHospitalDeviceBinding
import com.example.apiexample.model.DeviceModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HospitalDeviceActivity(private var ctx:Context) : AppCompatActivity() {
    private lateinit var binding: ActivityHospitalDeviceBinding
    private lateinit var adapter: HospitalDeviceAdapter
    private var hospitalDeviceList = ArrayList<DeviceModel.Data.Data?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalDeviceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.VISIBLE
        binding.rvDeviceId.layoutManager = LinearLayoutManager(this)

        var hospitalNames = intent.getStringExtra("hospitalName")

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val deviceResponse = RetrofitInstance.deviceApi.getHospitalDevice("Bearer "+getString(R.string.api_key), "KGMU")
                Log.d("DeviceResponse", "onCreate: $deviceResponse")
                if(deviceResponse.body()?.HospitalModelStatus == 200){
                    Log.d("DeviceResponse", deviceResponse.body()?.HospitalModelData?.HospitalModelData.toString())
                    hospitalDeviceList = deviceResponse.body()?.HospitalModelData?.HospitalModelData as ArrayList<DeviceModel.Data.Data?>

                    withContext(Dispatchers.Main){
                        adapter = HospitalDeviceAdapter(ctx, hospitalDeviceList)
                        binding.rvDeviceId.adapter = adapter
                        binding.progressBar.visibility = View.INVISIBLE
                    }

                }
            } catch (e: Exception){
                Log.d("DeviceResponse", "onCreate: $e")
            }
        }
    }
}