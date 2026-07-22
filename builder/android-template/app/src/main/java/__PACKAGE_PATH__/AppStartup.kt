package __PACKAGE_NAME__

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