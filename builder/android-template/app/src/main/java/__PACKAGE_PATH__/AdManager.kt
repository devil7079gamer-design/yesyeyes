package com.yesyeyes.app

import android.app.Activity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


object AdManager {


    private var interstitialAd: InterstitialAd? = null


    fun loadAd(
        activity: Activity
    ) {


        val request =
            AdRequest.Builder()
                .build()


        InterstitialAd.load(

            activity,

            "ca-app-pub-3940256099942544/1033173712",

            request,

            object : InterstitialAdLoadCallback() {


                override fun onAdLoaded(
                    ad: InterstitialAd
                ) {

                    interstitialAd = ad

                }


                override fun onAdFailedToLoad(
                    error: LoadAdError
                ) {

                    interstitialAd = null

                }


            }

        )

    }


    fun showAd(
        activity: Activity
    ) {


        interstitialAd?.show(
            activity
        )


        interstitialAd = null


    }


}
