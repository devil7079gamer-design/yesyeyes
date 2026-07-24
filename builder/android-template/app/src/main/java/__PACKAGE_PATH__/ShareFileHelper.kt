package com.yesyeyes.app

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File


object ShareFileHelper {


    fun shareFile(

        context: Context,

        file: File

    ) {


        val uri: Uri =

            FileProvider.getUriForFile(

                context,

                context.packageName + ".provider",

                file

            )


        val intent = Intent(

            Intent.ACTION_SEND

        )


        intent.type = "*/*"


        intent.putExtra(

            Intent.EXTRA_STREAM,

            uri

        )


        intent.addFlags(

            Intent.FLAG_GRANT_READ_URI_PERMISSION

        )


        context.startActivity(

            Intent.createChooser(

                intent,

                "Share File"

            )

        )


    }


}
