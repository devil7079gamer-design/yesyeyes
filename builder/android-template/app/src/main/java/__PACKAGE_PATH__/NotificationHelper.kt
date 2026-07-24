package com.yesyeyes.app

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build


class NotificationHelper(
    private val context: Context
) {


    private val channelId = "web_app_notifications"


    fun createChannel() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


            val channel = NotificationChannel(

                channelId,

                "App Notifications",

                NotificationManager.IMPORTANCE_DEFAULT

            )


            val manager =
                context.getSystemService(

                    Context.NOTIFICATION_SERVICE

                ) as NotificationManager


            manager.createNotificationChannel(channel)

        }

    }


}
