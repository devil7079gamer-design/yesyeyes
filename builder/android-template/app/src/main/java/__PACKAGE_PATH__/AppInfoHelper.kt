package com.yesyeyes.app

import android.content.Context


object AppInfoHelper {


    fun getName(

        context: Context

    ): String {


        return context.applicationInfo
            .loadLabel(

                context.packageManager

            )
            .toString()


    }


    fun getPackage(

        context: Context

    ): String {


        return context.packageName


    }


}
