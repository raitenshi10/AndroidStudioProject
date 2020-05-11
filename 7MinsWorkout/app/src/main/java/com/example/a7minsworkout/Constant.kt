package com.example.a7minsworkout

class Constant {
    companion object {
        fun defaultExerciseList() : ArrayList<ExerciseModels> {
            val exerciseList = ArrayList<ExerciseModels>()

            val jumpingJacks = ExerciseModels(
                1,
                "Jumping Jacks",
                R.drawable.ic_jumping_jacks,
                false,
                false
            )
            exerciseList.add(jumpingJacks)

            val squat = ExerciseModels(
                2,
                "Squat",
                R.drawable.ic_squat,
                false,
                false
            )
            exerciseList.add(squat)

            val abdominalCrunch = ExerciseModels(
                3,
                "Abdominal Crunch",
                R.drawable.ic_abdominal_crunch,
                false,
                false
            )
            exerciseList.add(abdominalCrunch)

            val highKneesRunning = ExerciseModels(
                4,
                "High Knees Running in Place",
                R.drawable.ic_high_knees_running_in_place,
                false,
                false
            )
            exerciseList.add(highKneesRunning)

            val lung = ExerciseModels(
                5,
                "Lunge",
                R.drawable.ic_lunge,
                false,
                false
            )
            exerciseList.add(lung)
            return exerciseList
        }
    }
}