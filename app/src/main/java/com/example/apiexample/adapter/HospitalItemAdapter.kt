package com.example.apiexample.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiexample.R
import com.example.apiexample.interfaces.OnClickListeners
import com.example.apiexample.model.Data
import com.example.apiexample.model.DeviceModel

class HospitalItemAdapter(private val context: Context, private val hospitalList: ArrayList<Data?>, private val clickListeners: OnClickListeners,
    private val hospitalDevicesList: ArrayList<DeviceModel.Data.Data?>) :
    RecyclerView.Adapter<HospitalItemAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvHospitalName: TextView = itemView.findViewById(R.id.tvName)
        val tvHospitalAddress: TextView = itemView.findViewById(R.id.tvAddress)
        val tvCity: TextView = itemView.findViewById(R.id.tvCity)
        val tvCountry: TextView = itemView.findViewById(R.id.tvCountry)
        val tvState: TextView = itemView.findViewById(R.id.tvState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hospital_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  hospitalList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hospitalItemModel = hospitalList[position]
        Log.d("OnBindViewHolder", "onBindViewHolder: ${hospitalItemModel?.HospitalModelHospitalName}")
        holder.tvHospitalName.text = "Hospital Name: " + hospitalItemModel?.HospitalModelHospitalName
        holder.tvHospitalName.setOnClickListener {
            Log.d("OnClick", "OnHospitalNameClick: called")
            clickListeners.onHospitalNameClickListener(hospitalItemModel?.HospitalModelHospitalName)
        }
        holder.tvHospitalAddress.text = "Address: "+ hospitalItemModel?.HospitalModelHospitalAddress
        holder.tvCity.text = "City: " + hospitalItemModel?.HospitalModelCity
        holder.tvCountry.text = "Country: "+ hospitalItemModel?.HospitalModelCountry
        holder.tvState.text = "State: " + hospitalItemModel?.HospitalModelState
    }
}