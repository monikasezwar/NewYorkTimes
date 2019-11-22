package com.example.newyorktimes.view.homeview

import android.app.Application
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.newyorktimes.R
import com.example.newyorktimes.common.*
import com.example.newyorktimes.network.RetrofitClientInstance
import com.example.newyorktimes.network.response.SectionResponse
import com.example.newyorktimes.network.service.SectionService
import com.example.newyorktimes.database.viewmodel.SectionViewModel
import com.example.newyorktimes.view.sectionListView.SectionListActivity
import kotlinx.android.synthetic.main.list_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainView(var mFragment: MainFragment){

    private lateinit var sectionResponse: SectionResponse
    private lateinit var mSectionViewModel: SectionViewModel

    fun onViewCreated(){
        mSectionViewModel = ViewModelProviders.of(mFragment).get(SectionViewModel::class.java)
        val list = listOf("Science", "Technology","Business", "World", "Movies","Travel")
        val mAdapter = ArrayAdapter(mFragment.requireContext(), R.layout.list_item,list)
        mFragment.list_view.adapter = mAdapter

        mFragment.list_view.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {

                // value of item that is clicked
                val itemValue = mFragment.list_view.getItemAtPosition(position) as String

                // Toast the values
                Toast.makeText(mFragment.context,
                    "Position :$position\nItem Value : $itemValue", Toast.LENGTH_LONG)
                    .show()

                getSectionDetails(itemValue)
            }
        }
    }

    fun getSectionDetails(sectionName: String){
        val intent = Intent(AppApplication.instance, SectionListActivity::class.java)
        intent.putExtra(Constants.SECTION_NAME,sectionName)
        mFragment.requireActivity().startActivity(intent)
    }

}