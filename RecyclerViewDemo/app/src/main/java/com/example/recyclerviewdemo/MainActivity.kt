package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var myRecyclerView: RecyclerView
    private lateinit var user: ArrayList<UserModels>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myRecyclerView = findViewById(R.id.myRecyclerView)
        myRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        user = ArrayList<UserModels>()
        user.add(UserModels("ilham", "Uvuvuevue onyetnye vue ossas"))
        user.add(UserModels("ilham", "Uvuvuevue onyetnye vue ossas"))
        user.add(UserModels("ilham", "Uvuvuevue onyetnye vue ossas"))
        user.add(UserModels("ilham", "Uvuvuevue onyetnye vue ossas"))
        user.add(UserModels("ilham", "Uvuvuevue onyetnye vue ossas"))
        user.add(UserModels("ilham", "Uvuvuevue onyetnye vue ossas"))
        user.add(UserModels("ilham", "Uvuvuevue onyetnye vue ossas"))
        user.add(UserModels("ilham", "Uvuvuevue onyetnye vue ossas"))
        user.add(UserModels("ilham", "Uvuvuevue onyetnye vue ossas"))
        user.add(UserModels("ilham", "Uvuvuevue onyetnye vue ossas"))

        var adapter = CustomAdapter(user)
        myRecyclerView.setAdapter(adapter)


    }
}
