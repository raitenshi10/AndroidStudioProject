package com.example.sqlitedemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_row.view.*

class EmailAdapter(private val email: ArrayList<EmailModel>?, private val context: Context): RecyclerView.Adapter<EmailAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvEmail: TextView = view.tvEmail
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return email!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model: EmailModel = email!![position]
        holder.tvEmail.text = model.email
    }
}