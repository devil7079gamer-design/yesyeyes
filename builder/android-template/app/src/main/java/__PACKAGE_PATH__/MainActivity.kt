package com.yesyeyes.app

import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)

        // Configure WebView
        WebSettingsManager.configure(webView)
        webView.webViewClient = WebViewClientManager()
        webView.addJavascriptInterface(WebBridge(this), "Android")

        // Load Website
        webView.loadUrl(AppConfig.WEBSITE_URL)

        // Load Ads (only if enabled)
        if (ReleaseConfig.ENABLE_ADS) {
            try {
                AdManager.loadAd(this)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
            super.onBackPressed()
        }
    }
}
