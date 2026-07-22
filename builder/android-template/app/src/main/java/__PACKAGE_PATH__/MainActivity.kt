package __PACKAGE_NAME__

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebView
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    private lateinit var webView: WebView


    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_main
        )


        webView =
            findViewById(
                R.id.webView
            )


        // Setup WebView

        WebSettingsManager.configure(
            webView
        )


        webView.webViewClient =
            WebViewClientManager()


        webView.addJavascriptInterface(

            WebBridge(
                this
            ),

            "Android"

        )


        // Load Website

        webView.loadUrl(

            AppConfig.WEBSITE_URL

        )


        // Load Ads

        if (

            ReleaseConfig.ENABLE_ADS

        ) {


            AdManager.loadAd(

                this

            )


        }


    }



    override fun onBackPressed() {


        if (

            webView.canGoBack()

        ) {


            webView.goBack()


        }

        else {


            Toast.makeText(

                this,

                "Press back again to exit",

                Toast.LENGTH_SHORT

            ).show()


        }


    }


}