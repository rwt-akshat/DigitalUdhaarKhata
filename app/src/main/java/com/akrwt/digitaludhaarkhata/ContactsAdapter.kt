package com.akrwt.digitaludhaarkhata

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(private var ctx: Context,private var contactsList: ArrayList<ContactsModel>) :
    RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.findViewById<TextView>(R.id.tvName)!!
        val number = itemView.findViewById<TextView>(R.id.tvNumber)!!
        val image = itemView.findViewById<ImageView>(R.id.iv_profile)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(ctx).inflate(R.layout.item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = contactsList[position]
        holder.name.text = current.name
        holder.number.text = current.number
        val i = current.image
        if(i == null){
            holder.image.setImageResource(R.drawable.ic_contacts)
        }else {
            holder.image.setImageBitmap(current.image)
        }
        holder.itemView.setOnClickListener{
            val intent = Intent(ctx,KhataActivity::class.java)
            intent.putExtra("name",current.name)
            ctx.startActivity(intent)
        }
    }
    fun setFilter(listItem: ArrayList<ContactsModel>) {
        contactsList = ArrayList()
        contactsList.addAll(listItem)
        this.notifyDataSetChanged()
    }
}