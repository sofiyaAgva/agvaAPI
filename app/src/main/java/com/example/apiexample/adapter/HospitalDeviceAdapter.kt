package com.example.apiexample.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiexample.R
import com.example.apiexample.model.DeviceModel

class HospitalDeviceAdapter(private val context: Context, private val deviceList: ArrayList<DeviceModel.Data.Data?>)
    :RecyclerView.Adapter<HospitalDeviceAdapter.ViewHolder>(){

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvDeviceId: TextView = itemView.findViewById(R.id.tvDeviceId)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.device_items, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val deviceItems = deviceList[position]
        Log.d("DeviceItems", "onBindViewHolder: ${deviceItems?.HospitalModelDeviceId}")
        holder.tvDeviceId.text = deviceItems?.HospitalModelDeviceId
    }

    override fun getItemCount(): Int {
        return deviceList.size
    }

}