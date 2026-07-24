package com.yesyeyes.app

import android.app.Activity


object AppExitHelper {


    fun close(

        activity: Activity

    ) {


        activity.finishAffinity()


    }


}
