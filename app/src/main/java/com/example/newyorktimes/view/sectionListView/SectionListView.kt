package com.example.newyorktimes.view.sectionListView

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newyorktimes.common.Constants
import com.example.newyorktimes.database.viewmodel.SectionViewModel
import com.example.newyorktimes.network.response.SectionResponse
import kotlinx.android.synthetic.main.section_list_fragment.*

class SectionListView(val mFragment: SectionListFragment) {

    private lateinit var sectionName : String
    private lateinit var mSectionViewModel: SectionViewModel

    fun onViewCreated(){
        mSectionViewModel = ViewModelProviders.of(mFragment).get(SectionViewModel::class.java)
        sectionName = mFragment.arguments?.get(Constants.SECTION_NAME).toString()
        setSelectedSectionData()
        setListener()
    }

    private fun setListener(){
        mFragment.refresh_button.setOnClickListener{
            mSectionViewModel.getRefreshData(sectionName)
        }
    }

    private fun setSelectedSectionData(){
        mFragment.section_name.text = sectionName
        mSectionViewModel.getSectionContentLive(sectionName).observe(mFragment, Observer {
            if(it.toString().isEmpty()){
                Toast.makeText(mFragment.requireContext(),"Response is empty",Toast.LENGTH_LONG);
            }else{
                initializeSectionAdapter(it.results)
            }
        })
    }

    private fun initializeSectionAdapter(it: List<SectionResponse.SectionResult>) {
        with( mFragment.recyler_view){
            layoutManager = LinearLayoutManager(mFragment.requireContext())
            adapter = NewsSectionAdapter(mFragment.requireContext(),sectionName,it)

        }
    }

}