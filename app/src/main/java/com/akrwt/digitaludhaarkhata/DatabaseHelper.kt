package com.akrwt.digitaludhaarkhata

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    companion object {
        const val DATABASE_NAME = "khata.db"
        const val TABLE_NAME = "khata_table"
        const val COL_1 = "ID"
        const val COL_2 = "UserName"
        const val COL_3 = "Giver"
        const val COL_4 = "Take"
        const val COL_5 = "Give"
        const val COL_6 = "Time"
        const val COL_7 = "Date"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT , UserName TEXT, Giver TEXT, Take TEXT, Give TEXT, Time TEXT, Date TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(userName: String, giver: String, take: String, give: String, time: String,date:String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, userName)
        contentValues.put(COL_3, giver)
        contentValues.put(COL_4, take)
        contentValues.put(COL_5, give)
        contentValues.put(COL_6, time)
        contentValues.put(COL_7,date)
        db.insert(TABLE_NAME, null, contentValues)
    }

    val allData: Cursor
        get() {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
            return res
        }
}