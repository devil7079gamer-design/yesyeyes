package __PACKAGE_NAME__

import android.webkit.CookieManager
import android.webkit.WebView


object CookieManagerHelper {


    fun enable(
        webView: WebView
    ) {


        val cookieManager =
            CookieManager.getInstance()


        cookieManager.setAcceptCookie(
            true
        )


        cookieManager.setAcceptThirdPartyCookies(
            webView,
            true
        )


    }


    fun clear() {


        CookieManager.getInstance()
            .removeAllCookies(null)


        CookieManager.getInstance()
            .flush()

    }


}