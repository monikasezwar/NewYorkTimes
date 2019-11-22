package com.example.newyorktimes.view.sectionListView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newyorktimes.R
import com.example.newyorktimes.network.response.SectionResult
import com.squareup.picasso.Picasso

class NewsSectionAdapter(val context: Context, var mList: List<SectionResult>): RecyclerView.Adapter<NewsSectionAdapter.NewsSectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsSectionViewHolder {
       return NewsSectionViewHolder(LayoutInflater.from(context).inflate(R.layout.section_list_item, parent))
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: NewsSectionViewHolder, position: Int) {
        val item = mList[position]
        holder.authorName.text = item.byline
        holder.articleTitle.text = item.title
        val url = item.url
        if (!url.isNullOrEmpty()) {
            Picasso.get()
                .load(url)
                .placeholder(R.drawable.no_internet)
                .resize(320,80)
                .centerInside()
                .into(holder.thumbnail)
        }


    }


    inner class NewsSectionViewHolder(view: View): RecyclerView.ViewHolder(view){
        val authorName = view.findViewById<TextView>(R.id.author)
        val articleTitle = view.findViewById<TextView>(R.id.title)
        val thumbnail = view.findViewById<ImageView>(R.id.thumbnail)
    }

}