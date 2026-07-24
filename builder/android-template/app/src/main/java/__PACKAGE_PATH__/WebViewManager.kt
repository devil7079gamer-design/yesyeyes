package com.yesyeyes.app

import android.annotation.SuppressLint
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient


class WebViewManager(
    private val webView: WebView
) {


    @SuppressLint("SetJavaScriptEnabled")
    fun setup() {


        val settings: WebSettings =
            webView.settings


        settings.javaScriptEnabled = true

        settings.domStorageEnabled = true

        settings.databaseEnabled = true

        settings.allowFileAccess = true

        settings.allowContentAccess = true

        settings.mediaPlaybackRequiresUserGesture = false

        settings.loadWithOverviewMode = true

        settings.useWideViewPort = true


        webView.webViewClient =
            WebViewClient()


        webView.webChromeClient =
            WebChromeClient()


        webView.addJavascriptInterface(

            WebAppInterface(
                webView.context
            ),

            "Android"

        )

    }


    fun loadUrl(url: String) {

        webView.loadUrl(url)

    }


    fun canGoBack(): Boolean {

        return webView.canGoBack()

    }


    fun goBack() {

        webView.goBack()

    }


    fun reload() {

        webView.reload()

    }

}
