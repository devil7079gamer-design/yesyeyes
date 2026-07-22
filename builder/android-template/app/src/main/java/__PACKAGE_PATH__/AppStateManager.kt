package __PACKAGE_NAME__

import android.content.Context


class AppStateManager(
    private val context: Context
) {


    private val prefs =
        context.getSharedPreferences(
            "app_state",
            Context.MODE_PRIVATE
        )


    fun save(
        key: String,
        value: String
    ) {


        prefs.edit()
            .putString(
                key,
                value
            )
            .apply()


    }


    fun get(
        key: String
    ): String? {


        return prefs.getString(
            key,
            null
        )


    }


    fun remove(
        key: String
    ) {


        prefs.edit()
            .remove(
                key
            )
            .apply()


    }


    fun clear() {


        prefs.edit()
            .clear()
            .apply()


    }


}