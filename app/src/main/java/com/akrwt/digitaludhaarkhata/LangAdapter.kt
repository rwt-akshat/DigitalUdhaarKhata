package com.akrwt.digitaludhaarkhata

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import io.paperdb.Paper

class LangAdapter(private var ctx: Context,private var langList: ArrayList<String>) :
    RecyclerView.Adapter<LangAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val langTv = itemView.findViewById<TextView>(R.id.langTV)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(ctx).inflate(R.layout.lang_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return langList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val lan = langList[position]
        holder.langTv.text = lan
        holder.itemView.setOnClickListener {
            when (lan) {
                "हिन्दी" -> {
                    Paper.book().write("language", "hi")
                    Toast.makeText(ctx, "Language changed successfully", Toast.LENGTH_LONG).show()
                    ctx.startActivity(Intent(ctx, ContactsActivity::class.java))
                }
                "தமிழ்" -> {
                    Paper.book().write("language", "ta")
                    Toast.makeText(ctx, "Language changed successfully", Toast.LENGTH_LONG).show()
                    ctx.startActivity(Intent(ctx, ContactsActivity::class.java))
                }
                "বাংলা" -> {
                    Paper.book().write("language", "be")
                    Toast.makeText(ctx, "Language changed successfully", Toast.LENGTH_LONG).show()
                    ctx.startActivity(Intent(ctx, ContactsActivity::class.java))
                }
                "తెలుగు" -> {
                    Paper.book().write("language", "te")
                    Toast.makeText(ctx, "Language changed successfully", Toast.LENGTH_LONG).show()
                    ctx.startActivity(Intent(ctx, ContactsActivity::class.java))
                }
                "मराठी" -> {
                    Paper.book().write("language", "ma")
                    Toast.makeText(ctx, "Language changed successfully", Toast.LENGTH_LONG).show()
                    ctx.startActivity(Intent(ctx, ContactsActivity::class.java))
                }
                "Urdu" -> {
                    Paper.book().write("language", "ur")
                    Toast.makeText(ctx, "Language changed successfully", Toast.LENGTH_LONG).show()
                    ctx.startActivity(Intent(ctx, ContactsActivity::class.java))
                }
                "ગુજરાતી" -> {
                    Paper.book().write("language", "gu")
                    Toast.makeText(ctx, "Language changed successfully", Toast.LENGTH_LONG).show()
                    ctx.startActivity(Intent(ctx, ContactsActivity::class.java))
                }
                "ಕನ್ನಡ" -> {
                    Paper.book().write("language", "ka")
                    Toast.makeText(ctx, "Language changed successfully", Toast.LENGTH_LONG).show()
                    ctx.startActivity(Intent(ctx, ContactsActivity::class.java))
                }
                "മലയാളം" -> {
                    Paper.book().write("language", "mal")
                    Toast.makeText(ctx, "Language changed successfully", Toast.LENGTH_LONG).show()
                    ctx.startActivity(Intent(ctx, ContactsActivity::class.java))
                }
                "ଓଡ଼ିଆ" -> {
                    Paper.book().write("language", "od")
                    Toast.makeText(ctx, "Language changed successfully", Toast.LENGTH_LONG).show()
                    ctx.startActivity(Intent(ctx, ContactsActivity::class.java))
                }
                "English" -> {
                    Paper.book().write("language", "en")
                    Toast.makeText(ctx, "Language changed successfully", Toast.LENGTH_LONG).show()
                    ctx.startActivity(Intent(ctx, ContactsActivity::class.java))
                }
                "ਪੰਜਾਬੀ" -> {
                    Paper.book().write("language", "pu")
                    Toast.makeText(ctx, "Language changed successfully", Toast.LENGTH_LONG).show()
                    ctx.startActivity(Intent(ctx, ContactsActivity::class.java))
                }
            }
        }
    }
}