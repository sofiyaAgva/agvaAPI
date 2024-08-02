package com.example.apiexample

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiexample.adapter.HospitalItemAdapter
import com.example.apiexample.api.RetrofitInstance
import com.example.apiexample.databinding.ActivityMainBinding
import com.example.apiexample.interfaces.OnClickListeners
import com.example.apiexample.model.Data
import com.example.apiexample.model.DeviceModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), OnClickListeners {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: HospitalItemAdapter
    private var hospitalList = ArrayList<Data?>()
    private var hospitalDeviceList = ArrayList<DeviceModel.Data.Data?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHospitalList.layoutManager = LinearLayoutManager(this)
        binding.progressBar.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.IO).launch {
           try {
                val response =  RetrofitInstance.api.getHospitals()
               Log.d("Response", "onCreate: ${response.body()?.HospitalModelStatusCode}")


               if(response.body()?.HospitalModelStatusCode == 200){
                   Log.d("Response", response.body()?.HospitalModelData.toString())
                   hospitalList = response.body()?.HospitalModelData!!
                   Log.d("Response", "onCreate: ${hospitalList.size}")
                   withContext(Dispatchers.Main){
//                       adapter = HospitalItemAdapter(this@MainActivity, hospitalList)
                       adapter = HospitalItemAdapter(this@MainActivity, hospitalList, this@MainActivity, hospitalDeviceList)
                       binding.rvHospitalList.adapter = adapter
                       binding.progressBar.visibility = View.INVISIBLE
                   }

               }


            } catch (e: Exception){
                Log.d("Response", "$e")
            }

        }


    }

    @SuppressLint("SuspiciousIndentation")
//    override fun onHospitalNameClickListener(deviceList: String?) {
//        Log.d("OnClick", "onHospitalNameClickListener: called")
//        val intent = Intent(this, HospitalDeviceActivity::class.java)
//        intent.putExtra("hospitalName")
//            startActivity(intent)
//    }
    override fun onHospitalNameClickListener(hospitalName: String?) {
        Log.d("OnClick", "onHospitalNameClickListener: called")
        val intent = Intent(this, HospitalDeviceActivity::class.java)
        intent.putExtra("hospitalName", hospitalName)
        startActivity(intent)
    }
}