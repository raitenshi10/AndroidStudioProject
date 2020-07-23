package com.example.dicodingfragment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dicodingfragment.R
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment(R.layout.fragment_category), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnToDetailCategoryFragment.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnToDetailCategoryFragment) {
            val mDetailCategoryFragment = DetailCategoryFragment()
            val mFragmentManager = fragmentManager

            val mBundle = Bundle()
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "LifeStyle")
            val description = "Kategori ini akan berisi produk-produk lifestyle"

            mDetailCategoryFragment.arguments = mBundle
            mDetailCategoryFragment.description =description


            mFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frameContainer, mDetailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}
