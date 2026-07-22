package __PACKAGE_NAME__

import android.content.Context
import android.content.Intent
import android.net.Uri


class BrowserHelper(
    private val context: Context
) {


    fun openExternal(
        url: String
    ) {


        val intent = Intent(

            Intent.ACTION_VIEW,

            Uri.parse(url)

        )


        context.startActivity(intent)

    }


}