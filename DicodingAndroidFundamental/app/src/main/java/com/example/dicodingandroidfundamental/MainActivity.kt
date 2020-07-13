package com.example.dicodingandroidfundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHitung.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnHitung) {
            val panjang = etPanjang.text.toString()
            val lebar = etLebar.text.toString()
            val tinggi = etTinggi.text.toString()
            val hasil = panjang.toInt()*lebar.toInt()*tinggi.toInt()
            tvHasil.text = hasil.toString()
        }
    }
}
