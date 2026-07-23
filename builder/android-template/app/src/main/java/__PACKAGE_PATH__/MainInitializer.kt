import android.app.Application


class MainInitializer : Application() {


    override fun onCreate() {

        super.onCreate()


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
