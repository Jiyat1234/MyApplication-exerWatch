//package com.example.myapplication
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import java.text.SimpleDateFormat
//import java.util.*
//
//class WearableDataAdapter : ListAdapter<SensorSample, WearableDataAdapter.VH>(DIFF) {
//
//    companion object {
//        private val DIFF = object : DiffUtil.ItemCallback<SensorSample>() {
//            override fun areItemsTheSame(oldItem: SensorSample, newItem: SensorSample): Boolean =
//                oldItem.ts == newItem.ts && oldItem.type == newItem.type
//
//            override fun areContentsTheSame(oldItem: SensorSample, newItem: SensorSample): Boolean =
//                oldItem == newItem
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
//        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_wearable_reading, parent, false)
//        return VH(v)
//    }
//
//    override fun onBindViewHolder(holder: VH, position: Int) {
//        holder.bind(getItem(position))
//    }
//
//    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val tvType: TextView = itemView.findViewById(R.id.item_type)
//        private val tvValue: TextView = itemView.findViewById(R.id.item_value)
//        private val tvTs: TextView = itemView.findViewById(R.id.item_ts)
//        private val fmt = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
//
//        fun bind(s: SensorSample) {
//            tvType.text = s.type
//            tvValue.text = s.value.toInt().toString()
//            tvTs.text = fmt.format(Date(s.ts))
//        }
//    }
//}
