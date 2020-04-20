package com.akrwt.digitaludhaarkhata

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.ActivityCompat
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Paper.init(this)
        supportActionBar!!.hide()

        sharedPreferences = getSharedPreferences("loggedIn", Context.MODE_PRIVATE)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        )
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_CONTACTS),
                12
            )


        val i = Intent(this, ContactsActivity::class.java)

        val editor = sharedPreferences.edit()

        english.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            )
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    12
                )
            else {
                editor.putString("loggedIn", "true")
                editor.apply()
                Paper.book().write("language", "en")
                startActivity(i)
            }
        }
        hindi.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            )
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    12
                ) else {
                editor.putString("loggedIn", "true")
                editor.apply()
                Paper.book().write("language", "hi")
                startActivity(i)
            }
        }
        tamil.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            )
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    12
                )
            else {
                editor.putString("loggedIn", "true")
                editor.apply()
                Paper.book().write("language", "ta")
                startActivity(i)
            }
        }
        bengali.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            )
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    12
                )
            else {
                editor.putString("loggedIn", "true")
                editor.apply()
                Paper.book().write("language", "be")
                startActivity(i)
            }
        }
        urdu.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            )
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    12
                )
            else {
                editor.putString("loggedIn", "true")
                editor.apply()
                Paper.book().write("language", "ur")
                startActivity(i)
            }
        }
        marathi.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            )
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    12
                )
            else {
                editor.putString("loggedIn", "true")
                editor.apply()
                Paper.book().write("language", "ma")
                startActivity(i)
            }
        }
        telugu.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            )
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    12
                )
            else {
                editor.putString("loggedIn", "true")
                editor.apply()
                Paper.book().write("language", "te")
                startActivity(i)
            }
        }
        gujarati.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            )
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    12
                )
            else {
                editor.putString("loggedIn", "true")
                editor.apply()
                Paper.book().write("language", "gu")
                startActivity(i)
            }
        }
        kannada.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            )
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    12
                )
            else {
                editor.putString("loggedIn", "true")
                editor.apply()
                Paper.book().write("language", "ka")
                startActivity(i)
            }
        }
        malayalam.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            )
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    12
                )
            else {
                editor.putString("loggedIn", "true")
                editor.apply()
                Paper.book().write("language", "mal")
                startActivity(i)
            }
        }
        odia.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            )
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    12
                ) else {
                editor.putString("loggedIn", "true")
                editor.apply()
                Paper.book().write("language", "od")
                startActivity(i)
            }
        }
        punjabi.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            )
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    12
                )
            else {
                editor.putString("loggedIn", "true")
                editor.apply()
                Paper.book().write("language", "pu")
                startActivity(i)
            }
        }
    }

    private fun setLanguage() {
        val language: String? = Paper.book().read("language")
        if (language == null) {
            Paper.book().write("language", "en")
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 12) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setLanguage()
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.READ_CONTACTS
                    )
                ) {
                    Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package", packageName, null)
                    intent.data = uri
                    startActivity(intent)
                    Toast.makeText(this, "Give permission first", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocaleHelper().onAttach(newBase!!, "en"))
    }

    override fun onStart() {
        super.onStart()
        val sharedPref = getSharedPreferences("loggedIn", Context.MODE_PRIVATE)
        val check = sharedPref.getString("loggedIn", "def")
        if (check == "true")
            startActivity(Intent(this, ContactsActivity::class.java))

    }
}
