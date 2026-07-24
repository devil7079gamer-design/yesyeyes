package com.yesyeyes.app

import android.content.Context


object AppVersionChecker {


    fun isUpdateRequired(

        current: Int,

        latest: Int

    ): Boolean {


        return latest > current


    }


    fun getCurrentVersion(

        context: Context

    ): Int {


        return try {


            val info =

                context.packageManager
                    .getPackageInfo(

                        context.packageName,

                        0

                    )


            info.longVersionCode.toInt()


        }

        catch (e: Exception) {


            1


        }


    }


}
