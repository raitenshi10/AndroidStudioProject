package com.example.dicodingrecyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dicodingrecyclerview.R
import com.example.dicodingrecyclerview.models.HeroModels
import kotlinx.android.synthetic.main.item_cardview_hero.view.*

class CardViewHeroAdapter(private val listHero: ArrayList<HeroModels>): RecyclerView.Adapter<CardViewHeroAdapter.MyCardViewViewHolder>() {

    class MyCardViewViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        fun bind(hero: HeroModels) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(img_item_photo)

                tv_item_name.text = hero.name
                tv_item_description.text = hero.description
                btn_set_favorite.setOnClickListener{ Toast.makeText(itemView.context, "Favorite ${hero.name}", Toast.LENGTH_SHORT).show() }
                btn_set_share.setOnClickListener { Toast.makeText(itemView.context, "Share ${hero.name}", Toast.LENGTH_SHORT).show() }
                itemView.setOnClickListener { Toast.makeText(itemView.context, "${hero.name} Diklik", Toast.LENGTH_SHORT).show() }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCardViewViewHolder {
        return MyCardViewViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_cardview_hero, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: MyCardViewViewHolder, position: Int) {
        holder.bind(listHero[position])
    }
}