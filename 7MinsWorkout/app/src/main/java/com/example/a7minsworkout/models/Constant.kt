package com.example.a7minsworkout.models

import com.example.a7minsworkout.R

class Constant {
    companion object {
        fun defaultExerciseList() : ArrayList<ExerciseModels> {
            val exerciseList = ArrayList<ExerciseModels>()

            val jumpingJacks = ExerciseModels(
                1,
                "JUMPING JACK",
                R.drawable.ic_jumping_jacks,
                false,
                false
            )
            exerciseList.add(jumpingJacks)

            val squat = ExerciseModels(
                2,
                "SQUAT",
                R.drawable.ic_squat,
                false,
                false
            )
            exerciseList.add(squat)

            val abdominalCrunch =
                ExerciseModels(
                    3,
                    "ABDOMINAL CRUNCH",
                    R.drawable.ic_abdominal_crunch,
                    false,
                    false
                )
            exerciseList.add(abdominalCrunch)

            val highKneesRunning =
                ExerciseModels(
                    4,
                    "HIGH KNEES RUNNING IN PLACE",
                    R.drawable.ic_high_knees_running_in_place,
                    false,
                    false
                )
            exerciseList.add(highKneesRunning)

            val lung = ExerciseModels(
                5,
                "LUNGE",
                R.drawable.ic_lunge,
                false,
                false
            )
            exerciseList.add(lung)

            val plank = ExerciseModels(
                6,
                "PLANK",
                R.drawable.ic_lunge,
                false,
                false
            )
            exerciseList.add(plank)

            val push_up = ExerciseModels(
                7,
                "PUSH UP",
                R.drawable.ic_lunge,
                false,
                false
            )
            exerciseList.add(push_up)

            val push_up_and_rotation =
                ExerciseModels(
                    8,
                    "PUSH UP AND ROTATION",
                    R.drawable.ic_lunge,
                    false,
                    false
                )
            exerciseList.add(push_up_and_rotation)

            val side_plank = ExerciseModels(
                9,
                "SIDE PLANK",
                R.drawable.ic_lunge,
                false,
                false
            )
            exerciseList.add(side_plank)

            val step_up_onto_chair =
                ExerciseModels(
                    10,
                    "STEP UP ONTO CHAIR",
                    R.drawable.ic_lunge,
                    false,
                    false
                )
            exerciseList.add(step_up_onto_chair)

            val triceps_dip_on_chair =
                ExerciseModels(
                    11,
                    "TRICEPS DIP ON CHAIR",
                    R.drawable.ic_lunge,
                    false,
                    false
                )
            exerciseList.add(triceps_dip_on_chair)

            val wall_sit = ExerciseModels(
                12,
                "WALL SIT",
                R.drawable.ic_lunge,
                false,
                false
            )
            exerciseList.add(wall_sit)
            return exerciseList
        }
    }
}