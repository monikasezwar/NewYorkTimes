package com.example.newyorktimes.view.sectionDetailView

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.newyorktimes.R
import kotlinx.android.synthetic.main.activity_web_view.*

class BrowserViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        startWebView()
    }

    private fun startWebView() {
        webview.settings.javaScriptEnabled = true
        webview.loadUrl(intent.getStringExtra("url"))
        webview.settings.loadWithOverviewMode = true
        webview.settings.useWideViewPort = true

        webview.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {

                progressbar.progress = progress

                if (progress == 100) {
                    progressbar.visibility = View.GONE
                }
            }
        }

        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return false

            }
        }
    }

}
