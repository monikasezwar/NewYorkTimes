package com.example.newyorktimes.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.newyorktimes.common.NoInternetDialog
import com.example.newyorktimes.common.Utils
import com.example.newyorktimes.database.AppRoomDatabase
import com.example.newyorktimes.database.dao.SectionDao
import com.example.newyorktimes.network.RetrofitClientInstance
import com.example.newyorktimes.network.response.SectionResponse
import com.example.newyorktimes.network.service.SectionService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SectionRepository(application: Application) {

    private var mSectionDao: SectionDao

    init {
        val db = AppRoomDatabase.getInstance(application)
        mSectionDao = db.sectionDao()
        requestDataFromServer()
    }

    fun getSectionContentLive(sectionName: String): LiveData<SectionResponse> {
        return mSectionDao.getSectionContentLive(sectionName)
    }

    fun requestDataFromServer(){
        if (Utils.isNetworkConnected()) {
            val service = RetrofitClientInstance.getRetrofitInstance().create(SectionService::class.java)
            val call = service.getSectionDetails()
            call.enqueue(object : Callback<SectionResponse> {
                override fun onResponse(
                    call: Call<SectionResponse>,
                    response: Response<SectionResponse>
                ) {
                    if (response.isSuccessful) {
                        if (response.body()?.status == "OK") {
                            mSectionDao.insertAll(response.body()!!)
                        } else {
                            /*response.body()?.status?.let { ServerError.handleServerError(it, mFragment.requireContext())
                            }*/
                            System.out.println("Server Error")
                        }
                    }
                }

                override fun onFailure(call: Call<SectionResponse>, t: Throwable) {
                    //Utils.showToast(mFragment.requireActivity(), "Something went wrong...Please try later!")
                    System.out.println("Something went wrong...Please try later!")
                }

            })
        } else {
            val noInternetDialog = NoInternetDialog()
            //noInternetDialog.show(mFragment.requireFragmentManager(), "nointernet")
            System.out.println("No internet")
        }
    }

}