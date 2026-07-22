package __PACKAGE_NAME__

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class DownloadReceiver : BroadcastReceiver() {


    override fun onReceive(

        context: Context,

        intent: Intent

    ) {


        if (

            intent.action == "android.intent.action.DOWNLOAD_COMPLETE"

        ) {


            LoggerConfig.log(

                "Download Completed"

            )


        }


    }


}