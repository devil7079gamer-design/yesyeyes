package __PACKAGE_NAME__

import android.webkit.WebView


object ErrorPageHelper {


    fun show(

        webView: WebView

    ) {


        val html = """

            <html>

            <body style="text-align:center;padding-top:50px;">

            <h2>No Internet Connection</h2>

            <p>Please check your network and try again.</p>

            </body>

            </html>

        """.trimIndent()


        webView.loadData(

            html,

            "text/html",

            "UTF-8"

        )


    }


}