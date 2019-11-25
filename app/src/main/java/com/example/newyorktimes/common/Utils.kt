package com.example.newyorktimes.common

import android.content.Context
import android.net.ConnectivityManager
import android.view.Gravity
import android.widget.Toast

object Utils {

    fun showToast(context: Context, message: String) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL, 0, 0)
        toast.show()
    }

    fun isNetworkConnected(): Boolean {
        val connManager = AppApplication.instance.getSystemService(
            Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connManager.activeNetworkInfo
        return info?.isConnected ?: false
    }
}