package com.yesyeyes.app

import android.util.Log


object LoggerConfig {


    private const val TAG =
        "WebsiteToApp"


    fun log(
        message: String
    ) {


        if (
            ReleaseConfig.ENABLE_LOGS
        ) {


            Log.d(

                TAG,

                message

            )


        }


    }


    fun error(
        message: String,
        throwable: Throwable? = null
    ) {


        if (
            ReleaseConfig.ENABLE_LOGS
        ) {


            Log.e(

                TAG,

                message,

                throwable

            )


        }


    }


}
