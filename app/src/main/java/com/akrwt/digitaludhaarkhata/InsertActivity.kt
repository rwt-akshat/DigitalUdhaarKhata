package com.akrwt.digitaludhaarkhata

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_insert.*
import java.util.*
import java.util.concurrent.TimeUnit

class InsertActivity : AppCompatActivity() {
    private var dbHelper = DatabaseHelper(this)
    private lateinit var i: String
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
        supportActionBar!!.title = "Add Amount"

        updateView(Paper.book().read<String>("language"))


        i = intent.getStringExtra("trans")!!
        name = intent.getStringExtra("name")!!

        btnAdd.setOnClickListener {
            if (etAmount.text.isEmpty()) {
                etAmount.error = "Empty"
                etAmount.requestFocus()
            } else
                addAmount()
        }
    }

    private fun addAmount() {


        val cal = Calendar.getInstance()
        var hour = cal.get(Calendar.HOUR).toString()

        val day = cal.get(Calendar.DAY_OF_MONTH)
        val month = cal.get(Calendar.MONTH)
        val year = cal.get(Calendar.YEAR)

        val date = "$day/$month/$year"

        if(hour.toInt()<10){
            hour = "0$hour"
        }
        var minute = cal.get(Calendar.MINUTE).toString()
        if(minute.toInt()<10){
            minute = "0$minute"
        }
        val time = "$hour:$minute"
        if (i == "Take") {
            insert(etAmount.text.toString(), "0",time,date)
        } else {
            insert("0", etAmount.text.toString(),time,date)
        }
    }

    private fun insert(take: String, give: String,time:String,date:String) {
        try {
            dbHelper.insertData(
                "User",
                name,
                take,
                give,
                time,
                date
            )
            Toast.makeText(applicationContext, "Saved", Toast.LENGTH_LONG).show()
            finish()
            val i = Intent(this, KhataActivity::class.java)
            i.putExtra("name", name)
            startActivity(i)

        } catch (ex: Exception) {
            ex.printStackTrace()
            Toast.makeText(applicationContext, ex.message.toString(), Toast.LENGTH_LONG).show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        val i = Intent(this, KhataActivity::class.java)
        i.putExtra("name", name)
        startActivity(i)
    }

    private fun updateView(lang: String?) {
        val context = LocaleHelper().setLocale(this, lang!!)
        val resources = context.resources

        etAmount.hint = resources.getString(R.string.amount)
        btnAdd.text = resources.getString(R.string.add)
    }
}
