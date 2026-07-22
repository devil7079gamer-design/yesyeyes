package __PACKAGE_NAME__

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


class NetworkChecker(
    private val context: Context
) {


    fun isConnected(): Boolean {


        val manager = context.getSystemService(

            Context.CONNECTIVITY_SERVICE

        ) as ConnectivityManager


        val network = manager.activeNetwork
            ?: return false


        val capabilities =
            manager.getNetworkCapabilities(network)
                ?: return false


        return capabilities.hasCapability(

            NetworkCapabilities.NET_CAPABILITY_INTERNET

        )

    }


}