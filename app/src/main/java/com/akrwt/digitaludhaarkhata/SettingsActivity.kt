package com.akrwt.digitaludhaarkhata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SettingsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LangAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        recyclerView = findViewById(R.id.langList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val arrList = ArrayList<String>()
        arrList.add("English")
        arrList.add("हिन्दी")
        arrList.add("தமிழ்")
        arrList.add("বাংলা")
        arrList.add("తెలుగు")
        arrList.add("मराठी")
        arrList.add("Urdu")
        arrList.add("ગુજરાતી")
        arrList.add("ಕನ್ನಡ")
        arrList.add("മലയാളം")
        arrList.add("ଓଡ଼ିଆ")
        arrList.add("ਪੰਜਾਬੀ")

        adapter = LangAdapter(this,arrList)
        recyclerView.adapter = adapter

    }
}
