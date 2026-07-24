package com.yesyeyes.app

import android.webkit.WebView


object CacheManager {


    fun enable(
        webView: WebView
    ) {


        webView.settings.apply {

            cacheMode =
                android.webkit.WebSettings.LOAD_DEFAULT

        }


    }


    fun clear(
        webView: WebView
    ) {


        webView.clearCache(true)

        webView.clearHistory()

    }


}
