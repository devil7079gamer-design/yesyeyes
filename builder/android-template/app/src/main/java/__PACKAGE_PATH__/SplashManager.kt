package __PACKAGE_NAME__

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.View


class SplashManager(
    private val activity: Activity
) {


    fun hideSplash(
        view: View,
        delay: Long = 2000
    ) {


        Handler(
            Looper.getMainLooper()
        ).postDelayed({


            view.visibility =
                View.GONE


        }, delay)


    }


}