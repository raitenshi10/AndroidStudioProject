package com.example.dicodingrecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dicodingrecyclerview.R
import com.example.dicodingrecyclerview.models.HeroModels
import kotlinx.android.synthetic.main.item_row_hero.view.*

class HeroAdapter(private val heroList: ArrayList<HeroModels>): RecyclerView.Adapter<HeroAdapter.MyViewHolder>() {

    private var onItemClickCallback: OnItemClickCallBack? = null

    fun setOnItemCallback(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallback = onItemClickCallback

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroAdapter.MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_row_hero, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(heroList[position])
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hero: HeroModels) {
            with(itemView) {
                // Loading image with Glide library
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(55,55))
                    .into(img_item_photo)

                tv_item_name.text = hero.name
                tv_item_description.text = hero.description
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(hero) }
            }
        }
    }

    interface OnItemClickCallBack {
        fun onItemClicked(data: HeroModels)
    }
}