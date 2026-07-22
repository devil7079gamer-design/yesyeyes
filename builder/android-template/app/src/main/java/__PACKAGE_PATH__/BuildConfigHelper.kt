package __PACKAGE_NAME__

import android.content.Context


object BuildConfigHelper {


    fun getVersionName(
        context: Context
    ): String {


        return try {


            context.packageManager
                .getPackageInfo(

                    context.packageName,

                    0

                )
                .versionName ?: "1.0.0"


        }

        catch (e: Exception) {


            "1.0.0"


        }


    }


    fun getVersionCode(
        context: Context
    ): Long {


        return try {


            val info =

                context.packageManager
                    .getPackageInfo(

                        context.packageName,

                        0

                    )


            info.longVersionCode


        }

        catch (e: Exception) {


            1


        }


    }


}