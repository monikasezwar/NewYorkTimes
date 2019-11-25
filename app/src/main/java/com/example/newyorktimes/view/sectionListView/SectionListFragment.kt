package com.example.newyorktimes.view.sectionListView

import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newyorktimes.R

class SectionListFragment : Fragment(){

    private lateinit var mView: SectionListView

    companion object{
        fun newInstance(bundle: Bundle): SectionListFragment{
            val sectionListFragment = SectionListFragment()
            sectionListFragment.arguments = bundle
            return sectionListFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.section_list_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mView = SectionListView(this)
        mView.onViewCreated()
    }

}
