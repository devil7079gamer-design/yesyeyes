package com.yesyeyes.app

import android.content.Context
import android.os.Build


object DeviceInfo {


    fun getDeviceName(): String {

        return Build.MODEL

    }


    fun getAndroidVersion(): String {

        return Build.VERSION.RELEASE

    }


    fun getSDKVersion(): Int {

        return Build.VERSION.SDK_INT

    }


    fun getInfo(
        context: Context
    ): Map<String, String> {


        return mapOf(

            "device" to getDeviceName(),

            "android" to getAndroidVersion(),

            "sdk" to getSDKVersion().toString(),

            "package" to context.packageName

        )

    }


}
