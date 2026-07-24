package com.yesyeyes.app

import android.graphics.Bitmap
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient


class WebViewErrorHandler(

    private val onError: () -> Unit

) : WebViewClient() {


    override fun onReceivedError(

        view: WebView?,

        request: WebResourceRequest?,

        error: WebResourceError?

    ) {


        if (

            request?.isForMainFrame == true

        ) {


            onError()


        }


    }


    override fun onPageStarted(

        view: WebView?,

        url: String?,

        favicon: Bitmap?

    ) {


        super.onPageStarted(

            view,

            url,

            favicon

        )


    }


}
