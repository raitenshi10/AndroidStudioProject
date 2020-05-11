package com.example.a7minsworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_exercise.*

class ExerciseActivity : AppCompatActivity() {

    private var restTime: CountDownTimer? = null
    private var restProgress = 0
    private var exerciseTime: CountDownTimer? = null
    private var exerciseProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        // Setting Toolbar
        setSupportActionBar(toolbar_exercise)

        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
        }

        // Setting behavior of the toolbar back button
        toolbar_exercise.setNavigationOnClickListener {
            onBackPressed()
        }

        setupRestView()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTime != null) {
            restTime!!.cancel()
            restProgress = 0
        }
    }

    /** The methods all written here
     *
     */

    private fun setRestProgressBar() {
        progress_bar.progress = restProgress
        restTime = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restProgress ++
                progress_bar.progress = 10-restProgress
                tv_timer.text = (10-restProgress).toString()
            }
            override fun onFinish() {
                Toast.makeText(
                    this@ExerciseActivity,
                    "Here we go", Toast.LENGTH_SHORT)
                    .show()
                setupExerciseView()
            }
        }.start()
    }

    private fun setExerciseProgressBar() {
        progress_bar_exercise.progress = exerciseProgress
        exerciseTime = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress ++
                progress_bar_exercise.progress = 30-exerciseProgress
                tv_exercise.text = (30-exerciseProgress).toString()
            }
            override fun onFinish() {
                Toast.makeText(
                    this@ExerciseActivity,
                    "Next Exercise", Toast.LENGTH_LONG)
                    .show()
            }
        }.start()
    }

    // Setting up the view for the countdown before going to the exercise activity
    private fun setupRestView() {
        ll_rest_view.visibility = View.VISIBLE
        ll_exercise_view.visibility = View.GONE

        if(restTime != null) {
            restTime!!.cancel()
            restProgress = 0
        }
        setRestProgressBar()
    }

    // Setting up the view for the countdown in exercise activity
    private fun setupExerciseView() {
        ll_rest_view.visibility = View.GONE
        ll_exercise_view.visibility = View.VISIBLE

        if(exerciseTime != null) {
            exerciseTime!!.cancel()
            exerciseProgress = 0
        }
        setExerciseProgressBar()
    }
}
