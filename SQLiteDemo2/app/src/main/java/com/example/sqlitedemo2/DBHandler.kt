package com.example.sqlitedemo2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context: Context):
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    companion object {
        const val DATABASE_NAME = "Mahasiswa"
        const val DATABASE_TABLE = "users"
        const val DATABASE_VERSION = 1
        const val ID = "id"
        const val NAMA = "nama"
        const val EMAIL = "email"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABEL $DATABASE_TABLE" +
                    "$ID INTEGER PRIMARY KEY $NAMA TEXT $EMAIL TEXT"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $DATABASE_TABLE")
    }

    fun addEmployee(emp: EmployeeModel): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(ID, emp.id)
            put(NAMA, emp.name)
            put(EMAIL, emp.email)
        }
        val success = db.insert(DATABASE_TABLE, null, values)
        db.close()
        return success
    }

    fun viewEmploye(): ArrayList<EmployeeModel> {
        val db = this.readableDatabase
        val empList: ArrayList<EmployeeModel> = ArrayList()
        val selectQuery = "SELECT * FROM $DATABASE_TABLE"
        val cursor: Cursor?
        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: SQLException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var userId: Int?
        var userName: String?
        var userEmail: String?
        if (cursor.moveToFirst()) {
            do {
                userId = cursor.getInt(cursor.getColumnIndex("id"))
                userName = cursor.getString(cursor.getColumnIndex("nama"))
                userEmail = cursor.getString(cursor.getColumnIndex("email"))
                val emp = EmployeeModel(id = userId, name = userName, email = userEmail)
                empList.add(emp)
            } while (cursor.moveToNext())

        }
        db.close()
        return empList
    }

    fun deleteEmployee(emp: EmployeeModel): Int {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(ID, emp.id)
        }
        val success = db.delete(DATABASE_TABLE, "$ID=${emp.id}", null)
        db.close()
        return success
    }
}

