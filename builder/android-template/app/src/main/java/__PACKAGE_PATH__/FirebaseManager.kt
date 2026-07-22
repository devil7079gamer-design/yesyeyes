package __PACKAGE_NAME__

import android.content.Context
import com.google.firebase.messaging.FirebaseMessaging


object FirebaseManager {


    fun getToken(
        callback: (String) -> Unit
    ) {


        FirebaseMessaging.getInstance()
            .token
            .addOnCompleteListener { task ->


                if (task.isSuccessful) {


                    callback(
                        task.result
                    )


                }


            }


    }


    fun subscribeTopic(
        topic: String
    ) {


        FirebaseMessaging.getInstance()
            .subscribeToTopic(
                topic
            )


    }


    fun unsubscribeTopic(
        topic: String
    ) {


        FirebaseMessaging.getInstance()
            .unsubscribeFromTopic(
                topic
            )


    }


}