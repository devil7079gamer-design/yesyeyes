package __PACKAGE_NAME__

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import com.google.android.gms.location.LocationServices
import androidx.core.app.ActivityCompat


class LocationHelper(
    private val context: Context
) {


    fun getLocation(
        callback: (Double, Double) -> Unit
    ) {


        val client =
            LocationServices
                .getFusedLocationProviderClient(
                    context
                )


        if (
            ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {

            return

        }


        client.lastLocation
            .addOnSuccessListener { location ->


                location?.let {


                    callback(

                        it.latitude,

                        it.longitude

                    )


                }


            }


    }


}