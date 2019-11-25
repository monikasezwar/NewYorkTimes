package com.example.newyorktimes.database.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.newyorktimes.common.Constants
import com.example.newyorktimes.common.ServerError
import com.example.newyorktimes.common.Utils
import com.example.newyorktimes.database.AppRoomDatabase
import com.example.newyorktimes.database.dao.SectionDao
import com.example.newyorktimes.network.RetrofitClientInstance
import com.example.newyorktimes.network.response.SectionResponse
import com.example.newyorktimes.network.service.SectionService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SectionRepository(application: Application) {

    private var mSectionDao: SectionDao
    private var application: Application
    private val TAG = "SectionRepository"

    init {
        val db = AppRoomDatabase.getInstance(application)
        this.application = application
        mSectionDao = db.sectionDao()
        requestDataFromServer("science")
        requestDataFromServer("technology")
        requestDataFromServer("business")
        requestDataFromServer("world")
        requestDataFromServer("movies")
        requestDataFromServer("travel")
    }

    fun getSectionContentLive(sectionName: String): LiveData<SectionResponse> {
        return mSectionDao.getSectionContentLive(sectionName)
    }

    fun requestDataFromServer(sectionName: String){
        if (Utils.isNetworkConnected()) {
            val service = RetrofitClientInstance.getRetrofitInstance().create(SectionService::class.java)
            val call = service.getSectionDetails(sectionName,Constants.API_KEY)
            call.enqueue(object : Callback<SectionResponse> {
                override fun onResponse(call: Call<SectionResponse>, response: Response<SectionResponse>) {
                    if (response.isSuccessful) {
                        if (response.body()?.status == "OK") {
                            GlobalScope.launch(Dispatchers.IO) {
                                mSectionDao.insertAll(response.body()!!)
                            }
                        } else {
                            response.body()?.status?.let { ServerError.handleServerError(it,application)
                            }
                            Log.i(TAG,"Server Error")
                        }
                    }
                }

                override fun onFailure(call: Call<SectionResponse>, t: Throwable) {
                    Log.i(TAG,"Something went wrong...Please try later!")
                }

            })
        } else {
            Log.i(TAG,"No internet")
        }
    }

}