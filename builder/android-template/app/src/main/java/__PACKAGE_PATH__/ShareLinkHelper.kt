package com.yesyeyes.app

import android.content.Context
import android.content.Intent

object ShareLinkHelper {

    fun share(context: Context, title: String, link: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, title)
            putExtra(Intent.EXTRA_TEXT, link)
        }

        context.startActivity(
            Intent.createChooser(intent, "Share via")
        )
    }
}
