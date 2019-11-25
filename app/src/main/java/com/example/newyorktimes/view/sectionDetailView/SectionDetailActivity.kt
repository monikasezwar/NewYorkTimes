package com.example.newyorktimes.view.sectionDetailView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newyorktimes.R
import com.example.newyorktimes.common.Constants

class SectionDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.section_detail_activity)
        val bundle = Bundle()
        bundle.putInt(Constants.SECTION_POSITION, intent.getIntExtra(Constants.SECTION_POSITION,-1))
        bundle.putString(Constants.SECTION_NAME,intent.getStringExtra(Constants.SECTION_NAME))
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.container, SectionDetailFragment.newInstance(bundle)).commitNow()
        }
    }

}