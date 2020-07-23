package com.example.githubuserapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuserapp.R
import com.example.githubuserapp.adapter.UserAdapter
import com.example.githubuserapp.models.UserModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PARCELDATA = "000"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UserModel.getAll()
        setRecyclerView()
    }

     private fun setRecyclerView() {
         rvList.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
         rvList.setHasFixedSize(true)
         rvList.adapter = UserAdapter(
             this,
             UserModel.getAll()
         ) {
             val intent = Intent(this, DetailActivity::class.java)
             intent.putExtra(EXTRA_PARCELDATA, it)
             startActivity(intent)
         }
    }
}
