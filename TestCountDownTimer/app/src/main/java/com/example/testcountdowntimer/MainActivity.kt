package com.example.testcountdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Variable waktu hitung mundur
    private lateinit var countDownTimer: CountDownTimer
    // Variable durasi waktu hitung mundur dalam milisecond ( second x 1000 )
    private var timeDuration: Long = 60000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        tv_timer.text = "${(timeDuration/1000).toString()}"
        btn_start.setOnClickListener {
            onStartTime()
        }

        btn_reset.setOnClickListener {
            onResetTime()
        }
    }

    fun onStartTime() {
        countDownTimer = object : CountDownTimer(60000, 1000){
            override fun onFinish() {
                Toast.makeText(this@MainActivity, "Finished", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onTick(millisUntilFinished: Long) {
                tv_timer.text = (millisUntilFinished/1000).toString()
            }
        }.start()
    }

    fun onResetTime() {
        if (countDownTimer != null) {
            countDownTimer.cancel()
            tv_timer.text = (timeDuration/1000).toString()
        }
    }

    fun onPauseTime(){

    }
}
