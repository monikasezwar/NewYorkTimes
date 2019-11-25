package com.example.newyorktimes.view.sectionListView

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newyorktimes.R
import com.example.newyorktimes.common.AppApplication
import com.example.newyorktimes.common.Constants
import com.example.newyorktimes.network.response.SectionResponse
import com.example.newyorktimes.view.sectionDetailView.SectionDetailActivity
import com.squareup.picasso.Picasso

class NewsSectionAdapter(val context: Context,val sectionName: String, var mList: List<SectionResponse.SectionResult>): RecyclerView.Adapter<NewsSectionAdapter.NewsSectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsSectionViewHolder {
       return NewsSectionViewHolder(LayoutInflater.from(context).inflate(R.layout.section_list_item, parent,false))
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: NewsSectionViewHolder, position: Int) {
        val item = mList[position]
        holder.authorName.text = item.byline
        holder.articleTitle.text = item.title
        if(item.multimedia.isNotEmpty()) {
            val url = item.multimedia[0].url
            if (!url.isNullOrEmpty()) {
                Picasso.get()
                    .load(url)
                    .resize(320, 80)
                    .centerInside()
                    .into(holder.thumbnail)
            }
        }
    }


    inner class NewsSectionViewHolder(view: View): RecyclerView.ViewHolder(view){
        val authorName = view.findViewById<TextView>(R.id.author)
        val articleTitle = view.findViewById<TextView>(R.id.title)
        val thumbnail = view.findViewById<ImageView>(R.id.thumbnail)
        init {
            view.setOnClickListener {
                openDetailViewActivity()
            }
        }

        private fun openDetailViewActivity() {
            val intent = Intent(AppApplication.instance,SectionDetailActivity::class.java)
            intent.putExtra(Constants.SECTION_POSITION,adapterPosition)
            intent.putExtra(Constants.SECTION_NAME,sectionName)
            context.startActivity(intent)

        }
    }

}