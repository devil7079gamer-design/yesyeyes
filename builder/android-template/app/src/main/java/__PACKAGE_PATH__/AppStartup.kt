package com.yesyeyes.app

import android.content.Context


object AppStartup {


    fun initialize(

        context: Context

    ) {


        CrashHandler(
            context
        ).install()


        LoggerConfig.log(

            "Application Started"

        )


    }


}
