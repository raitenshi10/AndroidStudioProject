package com.example.a7minsworkout.models

data class ExerciseModels (
    val id: Int,
    val name: String,
    val image: Int,
    var isCompleted: Boolean ,
    var isSelected: Boolean
)