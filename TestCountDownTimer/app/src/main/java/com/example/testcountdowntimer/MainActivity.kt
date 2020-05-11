package com.example.testcountdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Variable waktu hitung mundur
    private  var countDownTimer: CountDownTimer? = null
    // Variable durasi waktu hitung mundur dalam milisecond ( second x 1000 )
    private var timeDuration: Long = 60000
    private var pauseOffset: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        tv_timer.text = "${(timeDuration/1000).toString()}"
        btn_start.setOnClickListener {
            onStartTime(pauseOffset)
        }

        btn_reset.setOnClickListener {
            onResetTime()
        }

        btn_pause.setOnClickListener {
            onPauseTime()
        }
    }

    private fun onStartTime(pauseOffsetL: Long?) {
        countDownTimer = object : CountDownTimer(timeDuration-pauseOffset, 1000){
            override fun onFinish() {
                Toast.makeText(this@MainActivity, "Finished", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onTick(millisUntilFinished: Long) {
                pauseOffset = timeDuration - millisUntilFinished
                tv_timer.text = (millisUntilFinished/1000).toString()
            }
        }.start()
    }

    private fun onResetTime() {
        if (countDownTimer != null) {
            countDownTimer!!.cancel()
            tv_timer.text = (timeDuration/1000).toString()
            countDownTimer = null
            pauseOffset = 0
        }
    }

    private fun onPauseTime(){
        if (countDownTimer != null) {
            countDownTimer!!.cancel()
        }

    }
}
