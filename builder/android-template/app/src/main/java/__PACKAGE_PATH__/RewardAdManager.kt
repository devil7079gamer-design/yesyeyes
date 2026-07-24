package com.yesyeyes.app

import android.app.Activity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback


object RewardAdManager {


    private var rewardedAd: RewardedAd? = null


    fun load(
        activity: Activity
    ) {


        RewardedAd.load(

            activity,

            "ca-app-pub-3940256099942544/5224354917",

            AdRequest.Builder()
                .build(),

            object : RewardedAdLoadCallback() {


                override fun onAdLoaded(
                    ad: RewardedAd
                ) {

                    rewardedAd = ad

                }


                override fun onAdFailedToLoad(
                    error: com.google.android.gms.ads.LoadAdError
                ) {

                    rewardedAd = null

                }


            }

        )

    }


    fun show(

        activity: Activity,

        reward: () -> Unit

    ) {


        rewardedAd?.show(

            activity

        ) {


            reward()

        }


        rewardedAd = null


    }


}
