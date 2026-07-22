package __PACKAGE_NAME__

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.webkit.URLUtil

class DownloadManagerHelper(
    private val context: Context
) {


    fun downloadFile(
        url: String,
        fileName: String?
    ) {

        val request = DownloadManager.Request(
            Uri.parse(url)
        )


        request.setTitle(
            fileName ?: URLUtil.guessFileName(
                url,
                null,
                null
            )
        )


        request.setDescription(
            "Downloading file..."
        )


        request.setNotificationVisibility(
            DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED
        )


        request.setDestinationInExternalPublicDir(
            Environment.DIRECTORY_DOWNLOADS,
            fileName ?: "download"
        )


        val manager =
            context.getSystemService(
                Context.DOWNLOAD_SERVICE
            ) as DownloadManager


        manager.enqueue(request)

    }

}