package com.example.newyorktimes.view.sectionDetailView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newyorktimes.R

class SectionDetailFragment: Fragment() {

    private lateinit var mView: SectionDetailView

    companion object{
        fun newInstance(bundle: Bundle): SectionDetailFragment {
            val sectionDetailFragment = SectionDetailFragment()
            sectionDetailFragment.arguments = bundle
            return sectionDetailFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.section_detail_list_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mView = SectionDetailView(this)
        mView.onViewCreated()
    }
}