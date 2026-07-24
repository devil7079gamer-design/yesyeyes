package com.yesyeyes.app

import android.app.Activity
import android.view.View


object FullscreenHelper {


    fun enable(
        activity: Activity
    ) {


        activity.window.decorView.systemUiVisibility =

            (
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            )

    }


    fun disable(
        activity: Activity
    ) {


        activity.window.decorView.systemUiVisibility =

            View.SYSTEM_UI_FLAG_VISIBLE


    }


}
