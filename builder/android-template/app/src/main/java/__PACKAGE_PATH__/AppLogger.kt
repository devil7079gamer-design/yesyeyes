package com.yesyeyes.app

import android.util.Log


object AppLogger {


    private const val TAG = "WebsiteToApp"


    fun d(
        message: String
    ) {


        Log.d(

            TAG,

            message

        )


    }


    fun e(
        message: String,
        error: Throwable? = null
    ) {


        Log.e(

            TAG,

            message,

            error

        )


    }


    fun i(
        message: String
    ) {


        Log.i(

            TAG,

            message

        )


    }


}
