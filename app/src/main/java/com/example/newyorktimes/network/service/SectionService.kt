package com.example.newyorktimes.network.service

import com.example.newyorktimes.network.ServerAPIs.API_GET_SCIENCE_SECTION
import com.example.newyorktimes.network.response.SectionResponse
import retrofit2.Call
import retrofit2.http.GET

interface SectionService {

    @GET(API_GET_SCIENCE_SECTION)
    fun getSectionDetails(): Call<SectionResponse>

}