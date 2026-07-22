package __PACKAGE_NAME__

import android.app.Activity


object AppExitHelper {


    fun close(

        activity: Activity

    ) {


        activity.finishAffinity()


    }


}