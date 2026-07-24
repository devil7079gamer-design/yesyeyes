package com.yesyeyes.app

import android.util.Patterns


object UrlValidator {


    fun isValid(

        url: String

    ): Boolean {


        return Patterns.WEB_URL
            .matcher(

                url

            )
            .matches()


    }


    fun normalize(

        url: String

    ): String {


        return if (

            url.startsWith("http")

        ) {

            url

        } else {

            "https://$url"

        }


    }


}
