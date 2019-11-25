package com.example.newyorktimes.network.service

import com.example.newyorktimes.network.response.SectionResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SectionService {

    @GET("{section}.json")
    fun getSectionDetails(@Path("section")section: String, @Query("api-key") key: String): Call<SectionResponse>

}