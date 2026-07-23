package __PACKAGE_NAME__

import android.app.Application

class App : Application() {

    override fun onCreate() {

        super.onCreate()

        MultiDex.install(this)

    }

}
