package com.example.dicodingrecyclerview.adapters

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dicodingrecyclerview.R
import com.example.dicodingrecyclerview.models.HeroModels
import kotlinx.android.synthetic.main.item_grid_hero.view.*
import kotlinx.android.synthetic.main.item_row_hero.view.*
import kotlinx.android.synthetic.main.item_row_hero.view.img_item_photo

class GridHeroAdapter(private val heroList: ArrayList<HeroModels>)
    :RecyclerView.Adapter<GridHeroAdapter.MyGridViewAdapter>() {

    inner class MyGridViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hero: HeroModels) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(img_grid_photo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyGridViewAdapter {
        return MyGridViewAdapter(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_grid_hero, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: MyGridViewAdapter, position: Int) {
        holder.bind(heroList[position])
    }
}