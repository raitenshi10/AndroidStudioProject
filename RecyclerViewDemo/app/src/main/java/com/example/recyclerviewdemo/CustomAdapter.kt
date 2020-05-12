package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class CustomAdapter (val userList: ArrayList<UserModels>?) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var user: UserModels = userList!!.get(position)
        holder.nama.text = user.nama
        holder.motto.text = user.motto
    }

    inner class MyViewHolder(item: View): RecyclerView.ViewHolder(item){
        var nama: TextView = item.findViewById(R.id.tvNama)
        var motto: TextView = item.findViewById(R.id.tvMotto)
    }
}