package __PACKAGE_NAME__

import android.app.Activity
import android.content.pm.ActivityInfo


object OrientationHelper {


    fun portrait(
        activity: Activity
    ) {

        activity.requestedOrientation =
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }


    fun landscape(
        activity: Activity
    ) {

        activity.requestedOrientation =
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    }


    fun unlock(
        activity: Activity
    ) {

        activity.requestedOrientation =
            ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

    }


}