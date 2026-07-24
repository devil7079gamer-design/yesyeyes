package com.yesyeyes.app

import android.content.Context


class CrashHandler(

    private val context: Context

) : Thread.UncaughtExceptionHandler {


    private val defaultHandler =
        Thread.getDefaultUncaughtExceptionHandler()


    override fun uncaughtException(

        thread: Thread,

        throwable: Throwable

    ) {


        LoggerConfig.error(

            "App crashed",

            throwable

        )


        defaultHandler?.uncaughtException(

            thread,

            throwable

        )


    }


    fun install() {


        if (

            ReleaseConfig.ENABLE_CRASH_REPORTING

        ) {


            Thread.setDefaultUncaughtExceptionHandler(

                this

            )


        }


    }


}
