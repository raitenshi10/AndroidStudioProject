package com.example.a7minsworkout.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minsworkout.R
import com.example.a7minsworkout.models.ExerciseModels
import kotlinx.android.synthetic.main.item_exercise_status.view.*

class ExerciseStatusAdapter(private val items: ArrayList<ExerciseModels>, private val context: Context): RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val tvItem = v.tvItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_exercise_status,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: ExerciseModels = items[position]
        holder.tvItem.text = model.id.toString()
        if (model.isSelected){
            holder.tvItem.background = ContextCompat.getDrawable(context,
                R.drawable.item_circular_thin_color_accent_border
            )
        }else if(model.isCompleted) {
            holder.tvItem.background = ContextCompat.getDrawable(context,
                R.drawable.item_circular_color_accent_background
            )
            holder.tvItem.setTextColor(Color.parseColor("#C4C4C4"))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}