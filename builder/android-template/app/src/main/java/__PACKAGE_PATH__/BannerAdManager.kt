package __PACKAGE_NAME__

import android.app.Activity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView


object BannerAdManager {


    fun load(
        adView: AdView
    ) {


        val request =
            AdRequest.Builder()
                .build()


        adView.loadAd(
            request
        )


    }


    fun pause(
        adView: AdView
    ) {


        adView.pause()


    }


    fun resume(
        adView: AdView
    ) {


        adView.resume()


    }


    fun destroy(
        adView: AdView
    ) {


        adView.destroy()


    }


}