package __PACKAGE_NAME__

import android.webkit.WebView
import android.webkit.WebSettings


object WebSettingsManager {


    fun configure(
        webView: WebView
    ) {


        val settings: WebSettings =
            webView.settings


        settings.javaScriptEnabled = true

        settings.domStorageEnabled = true

        settings.databaseEnabled = true

        settings.loadsImagesAutomatically = true

        settings.allowFileAccess = true

        settings.allowContentAccess = true

        settings.javaScriptCanOpenWindowsAutomatically = true

        settings.setSupportZoom(true)

        settings.builtInZoomControls = false

        settings.displayZoomControls = false

        settings.mediaPlaybackRequiresUserGesture = false


    }


}