package com.example.newyorktimes.database.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.newyorktimes.common.AppApplication
import com.example.newyorktimes.database.repository.SectionRepository
import com.example.newyorktimes.network.response.SectionResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SectionViewModel: ViewModel() {
    internal val sectionRepository: SectionRepository = SectionRepository(AppApplication.instance)

    fun getSectionContentLive(sectionName: String): LiveData<SectionResponse> {
        return sectionRepository.getSectionContentLive(sectionName)
    }

    fun getRefreshData(sectionName: String){
            sectionRepository.requestDataFromServer(sectionName)
    }

}