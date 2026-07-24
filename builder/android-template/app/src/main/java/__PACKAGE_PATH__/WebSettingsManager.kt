package com.yesyeyes.app

import android.annotation.SuppressLint
import android.os.Build
import android.webkit.CookieManager
import android.webkit.WebSettings
import android.webkit.WebView

object WebSettingsManager {

    @SuppressLint("SetJavaScriptEnabled")
    fun configure(webView: WebView) {

        val settings = webView.settings

        // Basic
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.databaseEnabled = true

        // Files
        settings.allowFileAccess = true
        settings.allowContentAccess = true

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            settings.allowFileAccessFromFileURLs = true
            settings.allowUniversalAccessFromFileURLs = true
        }

        // Images
        settings.loadsImagesAutomatically = true
        settings.blockNetworkImage = false

        // Zoom
        settings.setSupportZoom(true)
        settings.builtInZoomControls = false
        settings.displayZoomControls = false

        // Windows
        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.setSupportMultipleWindows(false)

        // Media
        settings.mediaPlaybackRequiresUserGesture = false

        // Cache
        settings.cacheMode = WebSettings.LOAD_DEFAULT

        // Mixed Content (HTTPS + HTTP)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.mixedContentMode =
                WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }

        // Cookies
        val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.setAcceptThirdPartyCookies(webView, true)
        }
    }
}
