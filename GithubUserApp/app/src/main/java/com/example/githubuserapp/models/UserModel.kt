package com.example.githubuserapp.models

import android.os.Parcelable
import com.example.githubuserapp.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel (
    val name: String,
    val username: String,
    val image: Int,
    val company: String,
    val location: String,
    val repository: Int,
    val follower: Int,
    val following: Int
): Parcelable {
    companion object {

        fun getAll(): ArrayList<UserModel> {
            val userList = ArrayList<UserModel>()
            val user1 = UserModel(
                "Jake Wharton",
                "JakeWharton",
                image = R.drawable.user1,
                company = "Google, Inc",
                location = "USA",
                follower = 56995,
                following = 12,
                repository = 102
            )
            userList.add(user1)

            val user2 = UserModel(
                "AMIT SHEKHA",
                "amitshekhariitbhu",
                image = R.drawable.user2,
                company = "@MindOrksOpenSource",
                location = "New Delhi, India",
                follower = 5153,
                following = 2,
                repository = 37
            )
            userList.add(user2)

            val user3 = UserModel(
                "Romain Guy",
                "romainguy",
                image = R.drawable.user3,
                company = "Google",
                location = "California",
                follower = 7972,
                following = 0,
                repository = 9
            )
            userList.add(user3)

            val user4 = UserModel(
                "Chris Banes",
                "chrisbanes",
                image = R.drawable.user4,
                company = "@google working on @android",
                location = "Sydney, Aaustralia",
                follower = 14725,
                following = 1,
                repository = 30
            )
            userList.add(user4)

            val user5 = UserModel(
                "David",
                "tipsy",
                image = R.drawable.user5,
                company = "Working Grup Two",
                location = "Trondheim, Norway",
                follower = 788,
                following = 0,
                repository = 56
            )
            userList.add(user5)

            val user6 = UserModel(
                "Ravi Tamada",
                "ravi8x",
                image = R.drawable.user6,
                company = "AndroidHive | Droid5",
                location = "India",
                follower = 18628,
                following = 3,
                repository = 28
            )
            userList.add(user6)

            val user7 = UserModel(
                "Deny Prasetyo",
                "jasoet",
                image = R.drawable.user7,
                company = "@gojek-engineering",
                location = "Kotagede, Yogyakarta, Indonesia",
                follower = 277,
                following = 30,
                repository = 44
            )
            userList.add(user7)

            val user8 = UserModel(
                "Budi Oktaviyan",
                "budioktaviyan",
                image = R.drawable.user8,
                company = "@KotlinID",
                location = "Jakarta, Indonesia",
                follower = 178,
                following = 23,
                repository = 110
            )
            userList.add(user8)

            val user9 = UserModel(
                "Hendi Santika",
                "hendisantika",
                image = R.drawable.user9,
                company = "@JVMDeveploperID @KotlinID @IDDevOps",
                location = "Bojongsoang-Bandung, Jawa Barat",
                follower = 428,
                following = 61,
                repository = 1064
            )
            userList.add(user9)

            val user10 = UserModel(
                "Sidiq Permana",
                "sidiqpermana",
                image = R.drawable.user10,
                company = "Nusantara Beta Studio",
                location = "Jakarta, Indonesia",
                follower = 465,
                following = 10,
                repository = 65
            )
            userList.add(user10)
            return userList
        }
    }
}