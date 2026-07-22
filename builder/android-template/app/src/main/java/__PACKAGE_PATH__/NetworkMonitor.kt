package __PACKAGE_NAME__

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest


class NetworkMonitor(

    private val context: Context

) {


    private var listener:
            ((Boolean) -> Unit)? = null


    private val manager =

        context.getSystemService(

            Context.CONNECTIVITY_SERVICE

        ) as ConnectivityManager



    fun start(

        callback: (Boolean) -> Unit

    ) {


        listener = callback


        val request = NetworkRequest.Builder()

            .addCapability(

                NetworkCapabilities.NET_CAPABILITY_INTERNET

            )

            .build()



        manager.registerNetworkCallback(

            request,

            object : ConnectivityManager.NetworkCallback() {


                override fun onAvailable(

                    network: Network

                ) {


                    listener?.invoke(

                        true

                    )


                }


                override fun onLost(

                    network: Network

                ) {


                    listener?.invoke(

                        false

                    )


                }


            }

        )


    }


    fun stop() {


        try {


            manager.unregisterNetworkCallback(

                object : ConnectivityManager.NetworkCallback(){}

            )


        }

        catch (_: Exception) {


        }


    }


}