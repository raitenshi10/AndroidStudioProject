package com.example.dicodingintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "name_extra"
        const val EXTRA_AGE = "age_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val text = "Name : $name and age : $age"
        tvExplicitIntentData.text = text
    }
}
