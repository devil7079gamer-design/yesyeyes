package com.yesyeyes.app

import android.content.Context
import org.json.JSONObject


object ConfigReader {


    fun read(
        context: Context
    ): JSONObject {


        val input =
            context.assets.open(
                "config.json"
            )


        val json =
            input.bufferedReader()
                .use {
                    it.readText()
                }


        return JSONObject(
            json
        )


    }


    fun getValue(

        context: Context,

        key: String

    ): String? {


        return try {


            read(context)
                .getString(key)


        }

        catch (e: Exception) {


            null


        }


    }


}
