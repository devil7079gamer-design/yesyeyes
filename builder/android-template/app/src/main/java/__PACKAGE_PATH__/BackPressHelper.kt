package com.yesyeyes.app

import android.app.Activity
import android.webkit.WebView


object BackPressHelper {


    fun handle(

        activity: Activity,

        webView: WebView

    ): Boolean {


        return if (webView.canGoBack()) {


            webView.goBack()

            true


        } else {


            activity.finish()

            true


        }


    }


}
