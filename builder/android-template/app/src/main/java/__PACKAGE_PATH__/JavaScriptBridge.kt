package com.yesyeyes.app

import android.content.Context
import android.webkit.JavascriptInterface


class JavaScriptBridge(

    private val context: Context

) {


    @JavascriptInterface
    fun showMessage(
        message: String
    ) {


        android.widget.Toast.makeText(

            context,

            message,

            android.widget.Toast.LENGTH_SHORT

        ).show()


    }


    @JavascriptInterface
    fun getPlatform(): String {


        return "Android"


    }


    @JavascriptInterface
    fun close() {


        android.os.Process.killProcess(

            android.os.Process.myPid()

        )


    }


}
