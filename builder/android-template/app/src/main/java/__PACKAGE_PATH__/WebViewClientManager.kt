package com.yesyeyes.app

import android.content.Intent
import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient


class WebViewClientManager : WebViewClient() {


    override fun shouldOverrideUrlLoading(

        view: WebView?,

        request: WebResourceRequest?

    ): Boolean {


        val url =
            request?.url.toString()


        return if (

            url.startsWith("http://")

            || url.startsWith("https://")

        ) {


            view?.loadUrl(
                url
            )

            true


        } else {


            try {


                view?.context?.startActivity(

                    Intent(

                        Intent.ACTION_VIEW,

                        Uri.parse(url)

                    )

                )


            }

            catch (e: Exception) {

                e.printStackTrace()

            }


            true

        }


    }


}
