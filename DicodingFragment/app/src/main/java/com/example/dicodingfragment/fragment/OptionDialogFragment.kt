package com.example.dicodingfragment.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.example.dicodingfragment.R
import kotlinx.android.synthetic.main.fragment_option_dialog.*

/**
 * A simple [Fragment] subclass.
 */
class OptionDialogFragment : DialogFragment(), View.OnClickListener {

    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_choose.setOnClickListener(this)
        btn_close.setOnClickListener(this)
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    override fun onClick(v: View) {
        when (v.id ) {
            R.id.btn_close -> dialog?.cancel()
            R.id.btn_choose -> {
                val checkedRadioButtonId = rgButton.checkedRadioButtonId
                if (checkedRadioButtonId != -1) {
                    var coach: String? = null
                    when (checkedRadioButtonId) {
                        R.id.rbSAFerguson -> coach = rbSAFerguson.text.toString().trim()
                        R.id.rbLVGaal -> coach = rbLVGaal.text.toString().trim()
                        R.id.rbMourinho -> coach = rbMourinho.text.toString().trim()
                        R.id.rbMoyes -> coach = rbMoyes.text.toString().trim()
                    }
                        optionDialogListener?.onOptionChoosen(coach)
                        dialog?.dismiss()
                }
            }
        }
    }

    interface OnOptionDialogListener {
        fun onOptionChoosen(text: String?)
    }
}
