package com.example.newyorktimes.view.sectionDetailView

import android.content.Intent
import android.text.TextUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.newyorktimes.common.AppApplication
import com.example.newyorktimes.common.Constants
import com.example.newyorktimes.database.viewmodel.SectionViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.section_detail_list_fragment.*
import okhttp3.internal.trimSubstring
import java.text.SimpleDateFormat
import java.util.TimeZone.getTimeZone

class SectionDetailView(val mFragment: Fragment){

    private lateinit var mSectionViewModel: SectionViewModel
    private var mPosition = -1
    private  lateinit var sectionName: String
    private lateinit var webViewUrl: String

    fun onViewCreated(){
        mSectionViewModel = ViewModelProviders.of(mFragment).get(SectionViewModel::class.java)
        mPosition = mFragment.arguments?.get(Constants.SECTION_POSITION) as Int
        sectionName = mFragment.arguments?.get(Constants.SECTION_NAME).toString()
        setDetailData()
        setListeners()
    }

    private fun setListeners() {
        mFragment.webview_link.setOnClickListener {
            val intent = Intent(AppApplication.instance, BrowserViewActivity::class.java)
            intent.putExtra("url", webViewUrl)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            mFragment.requireContext().startActivity(intent)
        }
    }

    private fun setDetailData(){
        mSectionViewModel.getSectionContentLive(sectionName).observe(mFragment, Observer {
            if(it.results[mPosition].multimedia.isNotEmpty()) {
                val url = it.results[mPosition].multimedia[0].url
                if (!url.isNullOrEmpty()) {
                    Picasso.get()
                        .load(url)
                        .resize(320, 80)
                        .centerInside()
                        .into(mFragment.coverImage_medium3By2)
                }
            }
            mFragment.title.text = it.results[mPosition].title
            mFragment.abstract_tv.text = it.results[mPosition].abstract
            mFragment.author_name.text = it.results[mPosition].byline
            mFragment.publish_date.text =  "Published On:" + it.results[mPosition].published_date.trimSubstring(0,10)
            webViewUrl = it.results[mPosition].url
            mFragment.webview_link.text = webViewUrl
        })
    }

}