package com.example.sqlitedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_row.*

class MainActivity : AppCompatActivity() {

    private lateinit var dbHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = DatabaseHandler(this)

        addRecord.setOnClickListener {
            addRecord(it)
        }

        setupRecyclerView()
    }

    private fun addRecord(it: View) {
        val email = etEmail.text.toString()
        if (email.isNotEmpty()) {
            val status = dbHandler.insert(EmailModel(0, email))
            if (status > -1) {
                Toast.makeText(applicationContext, "Data ditambahkan", Toast.LENGTH_LONG).show()
                etEmail.text.clear()
                setupRecyclerView()
            }
        } else {
            Toast.makeText(applicationContext, "Email tidak boleh kosong", Toast.LENGTH_LONG).show()
        }
    }

    private fun getItemsList(): ArrayList<EmailModel> {
        return dbHandler.getAll()
    }

    private fun setupRecyclerView() {
        if (getItemsList().size > 0) {
            rvRecord.layoutManager = LinearLayoutManager(this)
            val emailAdapter = EmailAdapter(getItemsList(), this)
            rvRecord.adapter = emailAdapter
        }

    }
}
