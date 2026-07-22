package __PACKAGE_NAME__

import android.app.Application


class MainInitializer : Application() {


    override fun onCreate() {

        super.onCreate()


        // Initialize analytics

        if (ReleaseConfig.ENABLE_ANALYTICS) {

            AppAnalytics(
                this
            ).logOpenApp()

        }


        // Initialize notifications

        NotificationHelper(
            this
        ).createChannel()


        // Load ads

        if (ReleaseConfig.ENABLE_ADS) {

            // Ads will load from activity

        }


    }


}