package com.yesyeyes.app

import android.content.Context
import android.provider.Settings


object SecurityManager {


    fun isDeveloperModeEnabled(
        context: Context
    ): Boolean {


        return Settings.Secure.getInt(

            context.contentResolver,

            Settings.Global.DEVELOPMENT_SETTINGS_ENABLED,

            0

        ) != 0


    }


    fun getDeviceId(
        context: Context
    ): String {


        return Settings.Secure.getString(

            context.contentResolver,

            Settings.Secure.ANDROID_ID

        )


    }


}
