package com.yesyeyes.app

import android.app.Application


class AppController : Application() {


    override fun onCreate() {

        super.onCreate()


        AppStartup.initialize(

            this

        )


        registerActivityLifecycleCallbacks(

            AppLifecycle()

        )


    }


}
