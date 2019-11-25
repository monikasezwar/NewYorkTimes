package com.example.newyorktimes.view.sectionListView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newyorktimes.R
import com.example.newyorktimes.common.Constants

class SectionListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.section_activity)
        val bundle = Bundle()
        bundle.putString(Constants.SECTION_NAME, intent.getStringExtra(Constants.SECTION_NAME))
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.container,SectionListFragment.newInstance(bundle)).commitNow()
        }
    }


}