package com.example.dicodingfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    var mFragmentManager = supportFragmentManager
    var mHomeFragment = HomeFragment()
    var fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (fragment !is HomeFragment) {
            Log.d("DicodingFragment", "Fragment Name: ${HomeFragment::class.java.simpleName}")
            mFragmentManager
                .beginTransaction()
                .add(R.id.frameContainer, mHomeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }
    }
}
