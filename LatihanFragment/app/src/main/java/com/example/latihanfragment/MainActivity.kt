package com.example.latihanfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihanfragment.fragment.FirstFragment

class MainActivity : AppCompatActivity() {

    private var mFirstFragment =
        FirstFragment()
    private var mFragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFragmentManager.beginTransaction().apply {
            add(R.id.fgContainer, mFirstFragment, FirstFragment::class.java.simpleName)
            commit()
        }
    }
}
