package com.yesyeyes.app

import android.content.Context
import android.content.Intent
import android.net.Uri


object DeepLinkHelper {


    fun handle(

        context: Context,

        url: String

    ) {


        try {


            val intent = Intent(

                Intent.ACTION_VIEW,

                Uri.parse(url)

            )


            context.startActivity(
                intent
            )


        }

        catch (e: Exception) {


            e.printStackTrace()


        }


    }


}
