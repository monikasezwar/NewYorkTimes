package com.example.newyorktimes.view.sectionListView

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newyorktimes.common.Constants
import com.example.newyorktimes.database.viewmodel.SectionViewModel
import com.example.newyorktimes.network.response.SectionResult
import kotlinx.android.synthetic.main.section_list_fragment.*

class SectionListView(val mFragment: SectionListFragment) {

    private lateinit var sectionName : String
    private lateinit var mSectionViewModel: SectionViewModel

    fun onViewCreated(){
        mSectionViewModel = ViewModelProviders.of(mFragment).get(SectionViewModel::class.java)
        sectionName = mFragment.arguments?.get(Constants.SECTION_NAME).toString()
        setSelectedSectionData()
    }

    fun setSelectedSectionData(){
        mSectionViewModel.init(sectionName)
        mSectionViewModel.getSectionContentLive(sectionName).observe(mFragment, Observer {
            initializeSectionAdapter(it.results)
        })
    }

    private fun initializeSectionAdapter(it: List<SectionResult>) {
        with( mFragment.recyler_view){
            layoutManager = LinearLayoutManager(mFragment.requireContext())
            adapter = NewsSectionAdapter(mFragment.requireContext(),it)

        }
    }

}