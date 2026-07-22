package __PACKAGE_NAME__

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class FirebaseMessagingService :

    FirebaseMessagingService() {


    override fun onMessageReceived(
        message: RemoteMessage
    ) {


        val title =
            message.notification?.title
                ?: "Notification"


        val body =
            message.notification?.body
                ?: ""


        showNotification(

            title,

            body

        )


    }


    private fun showNotification(

        title: String,

        body: String

    ) {


        val channelId =
            "default_channel"


        val manager =
            getSystemService(
                NOTIFICATION_SERVICE
            ) as NotificationManager


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


            val channel =
                NotificationChannel(

                    channelId,

                    "Default Notifications",

                    NotificationManager.IMPORTANCE_DEFAULT

                )


            manager.createNotificationChannel(
                channel
            )

        }


        val intent =
            Intent(
                this,
                MainActivity::class.java
            )


        val pendingIntent =
            PendingIntent.getActivity(

                this,

                0,

                intent,

                PendingIntent.FLAG_IMMUTABLE

            )


        val notification =
            NotificationCompat.Builder(

                this,

                channelId

            )
                .setSmallIcon(
                    android.R.drawable.ic_dialog_info
                )
                .setContentTitle(
                    title
                )
                .setContentText(
                    body
                )
                .setContentIntent(
                    pendingIntent
                )
                .setAutoCancel(
                    true
                )
                .build()


        manager.notify(

            1,

            notification

        )


    }


}