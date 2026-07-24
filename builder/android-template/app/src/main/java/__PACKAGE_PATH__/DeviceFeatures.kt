package com.yesyeyes.app

import android.content.Context
import android.content.pm.PackageManager


object DeviceFeatures {


    fun hasCamera(

        context: Context

    ): Boolean {


        return context.packageManager
            .hasSystemFeature(

                PackageManager.FEATURE_CAMERA_ANY

            )


    }


    fun hasGPS(

        context: Context

    ): Boolean {


        return context.packageManager
            .hasSystemFeature(

                PackageManager.FEATURE_LOCATION_GPS

            )


    }


    fun hasBluetooth(

        context: Context

    ): Boolean {


        return context.packageManager
            .hasSystemFeature(

                PackageManager.FEATURE_BLUETOOTH

            )


    }


}
