package __PACKAGE_NAME__

import android.app.NotificationManager
import android.content.Context


object AppNotificationManager {


    fun cancelAll(

        context: Context

    ) {


        val manager =

            context.getSystemService(

                Context.NOTIFICATION_SERVICE

            ) as NotificationManager


        manager.cancelAll()


    }


    fun cancel(

        context: Context,

        id: Int

    ) {


        val manager =

            context.getSystemService(

                Context.NOTIFICATION_SERVICE

            ) as NotificationManager


        manager.cancel(

            id

        )


    }


}