package com.akrwt.digitaludhaarkhata

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.paperdb.Paper
import java.util.*
import kotlin.collections.ArrayList

class ContactsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ContactsAdapter
    private lateinit var contactList: ArrayList<ContactsModel>
    private lateinit var newArr: ArrayList<ContactsModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        contactList = ArrayList()
        newArr = ArrayList()
        Paper.init(this)
        recyclerView = findViewById(R.id.contactsList)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        updateView(Paper.book().read<String>("language"))

        getContacts()
    }

    private fun getContacts() {

        val contacts = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )
        while (contacts!!.moveToNext()) {
            val name =
                contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            val number =
                contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                    .replace(" ", "")
            val photoUri =
                contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI))
            val c = ContactsModel()
            c.name = name
            c.number = number

            if (photoUri != null) {
                c.image = MediaStore.Images.Media.getBitmap(contentResolver, Uri.parse(photoUri))
            }
            contactList.add(c)
        }
        contacts.close()

        for (i in 0 until contactList.size - 1) {
            if (contactList[i].number != contactList[i + 1].number) {
                newArr.add(
                    ContactsModel(
                        contactList[i].name,
                        contactList[i].number,
                        contactList[i].image
                    )
                )
            }
        }
        adapter = ContactsAdapter(this, newArr)
        recyclerView.adapter = adapter

    }

    private fun updateView(lang: String?) {
        val context = LocaleHelper().setLocale(this, lang!!)
        val resources = context.resources

        supportActionBar!!.title = resources.getString(R.string.contacts)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)


        val item = menu!!.findItem(R.id.search)

        val searchView = item.actionView as androidx.appcompat.widget.SearchView
        searchView.maxWidth = Integer.MAX_VALUE

        val lang = Paper.book().read<String>("language")
        val context = LocaleHelper().setLocale(this, lang!!)

        searchView.queryHint = context.resources.getString(R.string.search)
        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {

                val filteredList: ArrayList<ContactsModel> = filter(newArr, newText)
                adapter.setFilter(filteredList)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.khataSetting -> {
                startActivity(Intent(this, SettingsActivity::class.java))
            }
        }


        return super.onOptionsItemSelected(item)
    }

    fun filter(p1: ArrayList<ContactsModel>, query: String): ArrayList<ContactsModel> {
        val myQuery = query.toLowerCase(Locale.ENGLISH)
        val filteredNameList: ArrayList<ContactsModel> = ArrayList()

        for (i: ContactsModel in p1) {
            val text: String = i.name.toLowerCase(Locale.ENGLISH)
            if (text.startsWith(myQuery)) {
                filteredNameList.add(i)
            }
        }
        return filteredNameList
    }
}
