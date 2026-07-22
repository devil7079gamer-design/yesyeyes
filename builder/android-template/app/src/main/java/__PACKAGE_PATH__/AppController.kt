package __PACKAGE_NAME__

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