package com.example.dicodingintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_fifth.*

class FifthActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 150
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        btnFinish.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnFinish) {
            if (rgNumber.checkedRadioButtonId != 0) {
                var value = 0
                when(rgNumber.checkedRadioButtonId) {
                    R.id.rb50 -> value = 50
                    R.id.rb100 -> value = 100
                    R.id.rb150 -> value = 150
                    R.id.rb200 -> value = 200
                    R.id.rb250 -> value = 250
                }

                val intent = Intent()
                intent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, intent)
                finish()
            }
        }
    }
}
