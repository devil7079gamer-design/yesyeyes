package com.yesyeyes.app

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


object NetworkInfoHelper {


    fun getType(
        context: Context
    ): String {


        val manager =

            context.getSystemService(

                Context.CONNECTIVITY_SERVICE

            ) as ConnectivityManager


        val network =

            manager.activeNetwork
                ?: return "No Connection"


        val capabilities =

            manager.getNetworkCapabilities(

                network

            )
                ?: return "Unknown"


        return when {


            capabilities.hasTransport(

                NetworkCapabilities.TRANSPORT_WIFI

            ) -> "WiFi"


            capabilities.hasTransport(

                NetworkCapabilities.TRANSPORT_CELLULAR

            ) -> "Mobile Data"


            else -> "Other"


        }


    }


}
