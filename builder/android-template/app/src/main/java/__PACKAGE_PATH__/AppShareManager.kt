package __PACKAGE_NAME__

import android.content.Context
import android.content.Intent


object AppShareManager {


    fun shareApp(

        context: Context

    ) {


        val message =

            "Download this app: " +
            context.packageName



        val intent = Intent(

            Intent.ACTION_SEND

        )


        intent.type = "text/plain"


        intent.putExtra(

            Intent.EXTRA_TEXT,

            message

        )


        context.startActivity(

            Intent.createChooser(

                intent,

                "Share App"

            )

        )


    }


}