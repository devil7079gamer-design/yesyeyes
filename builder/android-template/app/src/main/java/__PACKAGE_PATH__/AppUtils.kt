package com.yesyeyes.app

import android.content.Context
import android.widget.Toast

object AppUtils {

    fun toast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun isNullOrEmpty(value: String?): Boolean {
        return value.isNullOrEmpty()
    }

    fun appVersion(): String {
        return AppConfig.VERSION_NAME
    }

}
