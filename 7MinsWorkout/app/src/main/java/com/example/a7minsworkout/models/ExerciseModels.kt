package com.example.a7minsworkout.models

import com.example.a7minsworkout.R

data class ExerciseModels (
    val id: Int,
    val name: String,
    val image: Int,
    var isCompleted: Boolean ,
    var isSelected: Boolean
)
{
    companion object
    {
        fun getData(): ArrayList<ExerciseModels>{

            val exerciseList = ArrayList<ExerciseModels>()

            val jumpingJack = ExerciseModels(1, "Jumping Jacks", R.drawable.ic_jumping_jacks,
                isCompleted = false,
                isSelected = false
            )
            exerciseList.add(jumpingJack)

            val abdominalCrunch = ExerciseModels(2, "Abdominal Crunch", R.drawable.ic_abdominal_crunch,
                isCompleted = false,
                isSelected = false
            )
            exerciseList.add(abdominalCrunch)
            return exerciseList
    }
    }
}