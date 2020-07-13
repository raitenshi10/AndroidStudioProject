package com.example.dicodingintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fourth.*

class FourthActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val person = intent.getParcelableExtra(EXTRA_PERSON) as Person
        val text = """
            Name is : ${person.name}
            Age is : ${person.age}
            Email is : ${person.email}
            City is : ${person.city}
        """.trimIndent()
        tvExplicitIntentParcelable.text = text
    }
}
