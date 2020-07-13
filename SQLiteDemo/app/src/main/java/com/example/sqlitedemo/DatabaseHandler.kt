package com.example.sqlitedemo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "DB_EMAIL"
        private const val DATABASE_VERSION = 1
        private const val DATABASE_TABLE = "emailTable"
        private const val ID = "id"
        private const val EMAIL = "email"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $DATABASE_TABLE" +
                "($ID INTEGER PRIMARY_KEY, " +
                "$EMAIL TEXT)"
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $DATABASE_TABLE")
        onCreate(db)
    }

    // Getting all user
    fun getAll(): ArrayList<EmailModel> {
        val allEmail: ArrayList<EmailModel> = ArrayList()
        val db = this.readableDatabase
        val queryAll = "SELECT * FROM $DATABASE_TABLE"
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(queryAll, null)
        }catch (e: SQLiteException) {
            db.execSQL(queryAll)
            return ArrayList()
        }

        var id: Int?
        var email: String?
        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex(ID))
                email = cursor.getString(cursor.getColumnIndex(EMAIL))
                val email = EmailModel(id=id, email = email)
                allEmail.add(email)

            } while (cursor.moveToNext())
        }
        cursor.close()
        return allEmail
    }

    // Insert data
    fun insert(email: EmailModel): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(EMAIL, email.email)
        val success = db.insert(DATABASE_TABLE, null, values)
        db.close()
        return success
    }

    // Delete data
    fun delete(email: EmailModel): Int {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(ID, email.id)
        }
        val success = db.delete(DATABASE_TABLE, "$ID = ?", null )
        db.close()
        return success
    }
}