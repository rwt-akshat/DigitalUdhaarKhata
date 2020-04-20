package com.akrwt.digitaludhaarkhata

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_khata.*

class KhataAdapter(var context: Context, var khataList: ArrayList<KhataModel>) :
    RecyclerView.Adapter<KhataAdapter.MyViewHolder>() {

    private val khataTake = 0
    private val khataGive = 1


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val amount: TextView = itemView.findViewById(R.id.amount)
        val time: TextView = itemView.findViewById(R.id.time)
        val date: TextView = itemView.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return if (viewType == khataGive) {
            val v = LayoutInflater.from(context).inflate(R.layout.khata_give_layout, parent, false)
            MyViewHolder(v)
        } else {
            val v = LayoutInflater.from(context).inflate(R.layout.khata_take_layout, parent, false)
            MyViewHolder(v)
        }
    }

    override fun getItemCount(): Int {
        return khataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = khataList[position]
        if (current.name == current.sName) {
            if (current.take == "0") {
                holder.amount.text = current.give
                holder.time.text = current.time
                holder.date.text = current.date
            } else {
                holder.amount.text = current.take
                holder.time.text = current.time
                holder.date.text = current.take
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        return when {
            khataList[position].give == "0" -> {
                khataTake
            }
            khataList[position].take == "0" -> {
                khataGive
            }
            else -> -1
        }
    }
}