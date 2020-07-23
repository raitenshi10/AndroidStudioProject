package com.example.githubuserapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuserapp.R
import com.example.githubuserapp.models.UserModel
import kotlinx.android.synthetic.main.item_list.view.*

class UserAdapter(
    private val context: Context,
    private val user: ArrayList<UserModel>,
    private val listener: (UserModel) -> Unit
): RecyclerView.Adapter<UserAdapter.MyViewHolder>() {


    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val ivUserImage: ImageView = view.ivUserImage
        private val tvUser: TextView = view.tvUsername
        private val tvUserDescription: TextView = view.tvUserDescription
        fun bindView(userModel: UserModel, listener: (UserModel) -> Unit) {
            ivUserImage.setImageResource(userModel.image)
            tvUser.text = userModel.name
            tvUserDescription.text = userModel.username
            itemView.setOnClickListener{listener(userModel)}
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(user[position], listener)
    }
}