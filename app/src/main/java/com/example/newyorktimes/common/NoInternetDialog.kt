package com.example.newyorktimes.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.newyorktimes.R


class NoInternetDialog : DialogFragment() {
    private var imageview: ImageView? = null
    private var okGotIt: TextView? = null
    private var notificationHeader: TextView? = null
    private var notificationMessage: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.notification_dialog, container, false)
        imageview = view.findViewById(R.id.icon)
        okGotIt = view.findViewById(R.id.ok_message)
        notificationHeader = view.findViewById(R.id.notification_header)
        notificationMessage = view.findViewById(R.id.notification_message)

        //imageview.setImageDrawable(R.drawable.no_internet);
        okGotIt!!.setOnClickListener { dismiss() }
        notificationHeader!!.text = "No Internet"
        notificationMessage!!.text = "Please check your internet connection and try again"

        return view
    }

}
