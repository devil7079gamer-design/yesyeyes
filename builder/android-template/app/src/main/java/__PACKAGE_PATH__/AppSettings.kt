package __PACKAGE_NAME__

import android.content.Context


class AppSettings(

    context: Context

) {


    private val prefs =

        context.getSharedPreferences(

            "settings",

            Context.MODE_PRIVATE

        )


    fun setBoolean(

        key: String,

        value: Boolean

    ) {


        prefs.edit()

            .putBoolean(

                key,

                value

            )

            .apply()


    }


    fun getBoolean(

        key: String,

        default: Boolean = false

    ): Boolean {


        return prefs.getBoolean(

            key,

            default

        )


    }


    fun setString(

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


    fun getString(

        key: String

    ): String? {


        return prefs.getString(

            key,

            null

        )


    }


}