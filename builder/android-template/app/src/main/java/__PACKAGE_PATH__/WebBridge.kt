package com.yesyeyes.app

import android.content.Context
import android.webkit.JavascriptInterface
import org.json.JSONObject


class WebBridge(
    private val context: Context
) {


    @JavascriptInterface
    fun getDeviceInfo(): String {


        val data = DeviceInfo.getInfo(
            context
        )


        return JSONObject(
            data
        ).toString()

    }


    @JavascriptInterface
    fun closeApp() {

        android.os.Process.killProcess(
            android.os.Process.myPid()
        )

    }


    @JavascriptInterface
    fun shareText(
        text: String
    ) {


        val intent =
            android.content.Intent
                .createChooser(

                    android.content.Intent(
                        android.content.Intent.ACTION_SEND
                    ).apply {

                        type = "text/plain"

                        putExtra(
                            android.content.Intent.EXTRA_TEXT,
                            text
                        )

                    },

                    "Share"

                )


        context.startActivity(intent)

    }


}
