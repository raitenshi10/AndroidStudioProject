package com.example.dicodingfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicodingfragment.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    private val mFragmentManager = supportFragmentManager
    private val mHomeFragment = HomeFragment()
    private val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Checking if this page isNot HomeFragment()
        if (fragment !is HomeFragment ) {
            mFragmentManager.beginTransaction().apply {
                add(R.id.frameContainer, mHomeFragment, HomeFragment::class.java.simpleName)
                commit()
            }
        }
    }
}
