package __PACKAGE_NAME__

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics


class AppAnalytics(
    context: Context
) {


    private val analytics =
        FirebaseAnalytics.getInstance(
            context
        )


    fun logOpenApp() {


        analytics.logEvent(

            FirebaseAnalytics.Event.APP_OPEN,

            null

        )


    }


    fun logEvent(

        name: String,

        data: String? = null

    ) {


        val bundle =
            Bundle()


        data?.let {


            bundle.putString(
                "data",
                it
            )


        }


        analytics.logEvent(

            name,

            bundle

        )


    }


}