package com.example.githubuserapp.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubuserapp.R
import com.example.githubuserapp.models.UserModel
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val userDetail = intent.getParcelableExtra<UserModel>(MainActivity.EXTRA_PARCELDATA)

        ivDetailImage.setImageResource(userDetail.image)
        tvDetailName.text = userDetail.name
        tvDetailUsername.text = userDetail.username
        tvDetailCompany.text = "Company: ${userDetail.company}"
        tvDetailLocation.text = "Location: ${userDetail.location}"
        tvDetailRepository.text = "Repository: ${userDetail.repository}"
        tvDetailFollower.text = "Follower: ${userDetail.follower}"
        tvDetailFollowing.text = "Following: ${userDetail.following}"

    }
}
