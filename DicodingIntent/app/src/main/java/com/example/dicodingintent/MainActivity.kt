package com.example.dicodingintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_third.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val REQUEST_CODE = 150
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent.setOnClickListener(this)
        btnExplicitIntent.setOnClickListener(this)
        btnExplicitIntentWithParcelable.setOnClickListener(this)
        btnImplicitIntent.setOnClickListener(this)
        btnIntentWithResult.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btnIntent -> startActivity(Intent(this, SecondActivity::class.java))
            R.id.btnExplicitIntent -> {
                val moveWithData = Intent(this@MainActivity, ThirdActivity::class.java)
                moveWithData.apply {
                    putExtra(ThirdActivity.EXTRA_NAME, "Dicoding Boy")
                    putExtra(ThirdActivity.EXTRA_AGE, 10)
                }
                startActivity(moveWithData)
            }
            R.id.btnExplicitIntentWithParcelable -> {
                val person = Person(
                    "ilham",
                    1,
                    "ilhampti10@gmail.com",
                    "Bandung"
                )
                val moveWithParcelable = Intent(this, FourthActivity::class.java)
                moveWithParcelable.apply {
                    putExtra(FourthActivity.EXTRA_PERSON, person)
                }
                startActivity(moveWithParcelable)
            }
            R.id.btnImplicitIntent -> {
                val phone = "085624341817"
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $phone"))
                startActivity(intent)
            }
            R.id.btnIntentWithResult -> {
                val moveWithActivityResult = Intent(this@MainActivity, FifthActivity::class.java)
                startActivityForResult(moveWithActivityResult, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE ) {
            if (resultCode == FifthActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(FifthActivity.EXTRA_SELECTED_VALUE, 0)
                tvHasil.text = "Hasil: $selectedValue"
            }
        }
    }
}
