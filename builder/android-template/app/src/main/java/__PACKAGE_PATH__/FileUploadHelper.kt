package com.yesyeyes.app

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.webkit.ValueCallback
import android.webkit.WebChromeClient


class FileUploadHelper(
    private val activity: Activity
) {


    private var fileCallback:
            ValueCallback<Array<Uri>>? = null


    fun createChromeClient(): WebChromeClient {

        return object : WebChromeClient() {


            override fun onShowFileChooser(

                webView: android.webkit.WebView?,

                callback:
                ValueCallback<Array<Uri>>,

                params:
                FileChooserParams

            ): Boolean {


                fileCallback = callback


                val intent =
                    params.createIntent()


                activity.startActivityForResult(

                    intent,

                    2001

                )


                return true

            }

        }

    }


    fun handleResult(

        requestCode: Int,

        resultCode: Int,

        data: Intent?

    ) {


        if (requestCode == 2001) {


            val result =
                if (resultCode == Activity.RESULT_OK && data != null)

                    arrayOf(
                        data.data!!
                    )

                else

                    null


            fileCallback?.onReceiveValue(result)


            fileCallback = null

        }

    }

}
