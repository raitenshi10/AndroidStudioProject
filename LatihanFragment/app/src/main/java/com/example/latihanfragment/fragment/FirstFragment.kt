package com.example.latihanfragment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.latihanfragment.R
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_ToSecondFragment.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id ) {
                R.id.btn_ToSecondFragment -> {
                    val mSecondFragment =
                        SecondFragment()
                    val mFragmentManager = fragmentManager
                    mFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.fgContainer, mSecondFragment, SecondFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }
}

