package __PACKAGE_NAME__

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context


object ClipboardHelper {


    fun copy(

        context: Context,

        text: String

    ) {


        val clipboard =

            context.getSystemService(

                Context.CLIPBOARD_SERVICE

            ) as ClipboardManager


        val clip = ClipData.newPlainText(

            "text",

            text

        )


        clipboard.setPrimaryClip(

            clip

        )


    }


    fun paste(

        context: Context

    ): String? {


        val clipboard =

            context.getSystemService(

                Context.CLIPBOARD_SERVICE

            ) as ClipboardManager


        if (

            !clipboard.hasPrimaryClip()

        ) {

            return null

        }


        return clipboard.primaryClip

            ?.getItemAt(0)

            ?.text

            ?.toString()


    }


}