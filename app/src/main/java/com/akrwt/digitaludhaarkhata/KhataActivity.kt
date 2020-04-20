package com.akrwt.digitaludhaarkhata

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_khata.*
import kotlin.math.abs

class KhataActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: KhataAdapter
    private lateinit var mList: ArrayList<KhataModel>
    private var dbHelper = DatabaseHelper(this)
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_khata)
        updateView(Paper.book().read<String>("language"))

        name = intent.getStringExtra("name")!!
        supportActionBar!!.title = name
        mList = ArrayList()

        recyclerView = findViewById(R.id.khataList)
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        recyclerView.layoutManager = layoutManager

        view()

        getData()

        acceptPayment.setOnClickListener {
            val i = Intent(this, InsertActivity::class.java)
            i.putExtra("trans", "Take")
            i.putExtra("name", name)
            startActivity(i)
        }
        giveCredit.setOnClickListener {
            val i = Intent(this, InsertActivity::class.java)
            i.putExtra("trans", "Give")
            i.putExtra("name", name)
            startActivity(i)
        }
    }

    private fun getData() {
        var bal = 0
        var bal2 = 0
        for (i in mList) {
            if (name == i.sName) {
                bal += i.give.toInt()
                bal2 += i.take.toInt()
            }
        }
        val mainBal = bal - bal2
        val context = LocaleHelper().setLocale(this, Paper.book().read<String>("language"))
        val resources = context.resources
        val d = resources.getString(R.string.Due)
        val a = resources.getString(R.string.Advance)
        when {
            mainBal > 0 -> {
                balance.text = "₹${abs(mainBal)} " + d
                balance.setTextColor(Color.RED)
            }
            mainBal < 0 -> {
                balance.text = "₹${abs(mainBal)} " + a
                balance.setTextColor(Color.BLUE)
            }
            else -> {
                balance.text = "₹${abs(mainBal)}"
                balance.setTextColor(Color.BLUE)
            }
        }
    }


    private fun view() {
        val res = dbHelper.allData
        mList.clear()
        while (res.moveToNext()) {
            if (name == res.getString(2)) {
                mList.add(
                    KhataModel(
                        name,
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5),
                        res.getString(6)
                    )
                )
            }
        }

        if (mList.isEmpty()) {
            tv.visibility = View.VISIBLE
        } else {
            tv.visibility = View.GONE
            adapter = KhataAdapter(this, mList)
            recyclerView.adapter = adapter
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        startActivity(Intent(this, ContactsActivity::class.java))
    }

    private fun updateView(lang: String?) {
        val context = LocaleHelper().setLocale(this, lang!!)
        val resources = context.resources

        tv.text = resources.getString(R.string.no_transaction)
        balanceTV.text = resources.getString(R.string.balance)
        giveCredit.text = resources.getString(R.string.give_credit)
        acceptPayment.text = resources.getString(R.string.accept_payment)

    }
}
