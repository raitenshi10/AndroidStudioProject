package com.example.a7minsworkout.activity

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minsworkout.models.Constant
import com.example.a7minsworkout.models.ExerciseModels
import com.example.a7minsworkout.adapter.ExerciseStatusAdapter
import com.example.a7minsworkout.R
import kotlinx.android.synthetic.main.activity_exercise.*
import java.util.*
import kotlin.collections.ArrayList

class ExerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener{

    // Timer property
    private var restTime: CountDownTimer? = null
    private var restProgress = 0
    // Exercise property
    private var exerciseTime: CountDownTimer? = null
    private var exerciseProgress = 0
    private var exerciseList : ArrayList<ExerciseModels>? = null
    private var currentExercisePosition = -1
    // Text To Speech
    private var tts: TextToSpeech? = null
    private var player: MediaPlayer? = null
    // RecyclerView
    private var exerciseAdapter: ExerciseStatusAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        // Setting Toolbar
        setSupportActionBar(toolbar_exercise)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Setting behavior of the toolbar back button
        toolbar_exercise.setNavigationOnClickListener {
            onBackPressed()
        }

        tts = TextToSpeech(this, this)
        setupRestView()
        exerciseList =
            Constant.defaultExerciseList()
        setupExerciseStatusRecyclerView()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTime != null) {
            restTime!!.cancel()
            restProgress = 0
        }

        if (exerciseTime != null) {
            exerciseTime!!.cancel()
            exerciseProgress = 0
        }

        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }

        if (player != null) {
            player!!.stop()
        }
    }

    /** The methods all are written here
     *
     */
    // A Function to setting up the countdown progress bar
    private fun setRestProgressBar() {
        progress_bar.progress = restProgress
        restTime = object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restProgress ++
                progress_bar.progress = 5-restProgress
                tv_timer.text = (5-restProgress).toString()
            }
            override fun onFinish() {
                currentExercisePosition++
                exerciseList!![currentExercisePosition].isSelected = true
                exerciseAdapter!!.notifyDataSetChanged()
                setupExerciseView()
            }
        }.start()
    }
    // A Function to setting the countdown of exercise progress bar
    private fun setExerciseProgressBar() {
        progress_bar_exercise.progress = exerciseProgress
        exerciseTime = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress ++
                progress_bar_exercise.progress = 30-exerciseProgress
                tv_exercise.text = (30-exerciseProgress).toString()
            }
            override fun onFinish() {
                if (currentExercisePosition < exerciseList!!.size + 1) {
                    exerciseList!![currentExercisePosition].isSelected = false
                    exerciseList!![currentExercisePosition].isCompleted = true
                    exerciseAdapter!!.notifyDataSetChanged()
                    startActivity(Intent(this@ExerciseActivity, FinishActivity::class.java ))
                }
            }
        }.start()
    }

    // Setting up the view for the countdown before going to the exercise activity
    private fun setupRestView() {
        player = MediaPlayer.create(applicationContext,
            R.raw.press_start
        )
        player!!.isLooping = false
        player!!.start()

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
        speakOut(exerciseList!![currentExercisePosition].name)
        iv_exercise.setImageResource(exerciseList!![currentExercisePosition].image)
        tv_exercise_name.text = exerciseList!![currentExercisePosition].name
        tv_upcoming_exercise.text = exerciseList!![currentExercisePosition+1].name
    }

    // Initializing text to speech
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "language is missing or not supported")
            }
        }else {
            Log.e("TTS", "Initialization Failed")
        }
    }

    private fun speakOut(text: String) {
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "" )
    }

    // Setting up the recyclerview
    private fun setupExerciseStatusRecyclerView() {
        rvExerciseStatus.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL, false)
        exerciseAdapter =
            ExerciseStatusAdapter(
                exerciseList!!,
                this
            )
        rvExerciseStatus.adapter = exerciseAdapter
    }
}

