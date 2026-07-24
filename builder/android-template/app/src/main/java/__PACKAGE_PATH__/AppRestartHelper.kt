package com.yesyeyes.app

import android.app.Activity
import android.content.Intent

object AppRestartHelper {

    fun restart(activity: Activity) {
        val intent = activity.packageManager
            .getLaunchIntentForPackage(activity.packageName)

        intent?.addFlags(
            Intent.FLAG_ACTIVITY_NEW_TASK or
            Intent.FLAG_ACTIVITY_CLEAR_TASK
        )

        activity.startActivity(intent)
        activity.finish()
    }
}
