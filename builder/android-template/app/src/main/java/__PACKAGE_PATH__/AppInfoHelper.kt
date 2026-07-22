package __PACKAGE_NAME__

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