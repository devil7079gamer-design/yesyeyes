package com.yesyeyes.app

import android.content.Context
import android.content.Intent
import android.webkit.JavascriptInterface
import org.json.JSONObject

class WebBridge(
    private val context: Context
) {

    @JavascriptInterface
    fun getDeviceInfo(): String {
        return try {
            JSONObject(DeviceInfo.getInfo(context)).toString()
        } catch (e: Exception) {
            "{}"
        }
    }

    @JavascriptInterface
    fun closeApp() {
        android.os.Process.killProcess(android.os.Process.myPid())
    }

    @JavascriptInterface
    fun shareText(text: String) {
        try {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, text)
            }

            context.startActivity(
                Intent.createChooser(intent, "Share")
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
