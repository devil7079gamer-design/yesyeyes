package com.yesyeyes.app

import android.content.Context
import android.content.Intent
import android.net.Uri


class UpdateManager(
    private val context: Context
) {


    fun openUpdatePage(
        url: String
    ) {


        val intent = Intent(

            Intent.ACTION_VIEW,

            Uri.parse(url)

        )


        context.startActivity(intent)

    }


    fun checkVersion(

        currentVersion: String,

        latestVersion: String

    ): Boolean {


        return currentVersion != latestVersion

    }


}
