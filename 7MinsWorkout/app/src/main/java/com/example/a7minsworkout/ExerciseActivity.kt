package com.example.a7minsworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_exercise.*

class ExerciseActivity : AppCompatActivity() {

    private var restTime: CountDownTimer?? = null
    private var restProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        // Setting Toolbar
        setSupportActionBar(toolbar_exercise)

        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
        }
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

    private fun setRestProgressBar() {
        progress_bar.progress = restProgress
        restTime = object : CountDownTimer(10000, 1000) {
            override fun onFinish() {
                Toast.makeText(this@ExerciseActivity, "Here we go", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onTick(millisUntilFinished: Long) {
                restProgress ++
                progress_bar.progress = 10-restProgress
                tv_timer.text = (10-restProgress).toString()
            }
        }.start()
    }

    private fun setupRestView() {
        if(restTime != null) {
            restTime!!.cancel()
            restProgress = 0
        }
        setRestProgressBar()
    }
}
