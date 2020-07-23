package com.example.dicodingfragment.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dicodingfragment.ProfileActivity
import com.example.dicodingfragment.R
import kotlinx.android.synthetic.main.fragment_detail_category.*
import java.security.Provider

/**
 * A simple [Fragment] subclass.
 */
class DetailCategoryFragment : Fragment(R.layout.fragment_detail_category), View.OnClickListener {

    var description: String? = ""

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnProfile.setOnClickListener(this)
        btnShowDialog.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null) {
            val descFromBundel = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundel
        }

        if (arguments != null) {
            val categoryName = arguments?.getString(EXTRA_NAME)
            tvCategoryName.text = categoryName
            tvCategoryDescription.text = description

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXTRA_DESCRIPTION, description)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnShowDialog -> {
                val mOptionDialog = OptionDialogFragment()
                val mFragment = childFragmentManager
                mOptionDialog.show(mFragment, OptionDialogFragment::class.java.simpleName)
            }
            R.id.btnProfile -> startActivity(Intent(activity, ProfileActivity::class.java))
        }
    }

    internal var optionDialogListener: OptionDialogFragment.OnOptionDialogListener = object : OptionDialogFragment.OnOptionDialogListener {
        fun onOptionChosen(text: String?) {
            Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
        }

        override fun onOptionChoosen(text: String?) {
        }
    }
}
