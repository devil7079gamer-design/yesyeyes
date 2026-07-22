package __PACKAGE_NAME__

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionManager(
    private val activity: Activity
) {

    private val permissions = arrayOf(

        Manifest.permission.CAMERA,

        Manifest.permission.RECORD_AUDIO,

        Manifest.permission.ACCESS_FINE_LOCATION

    )


    fun requestPermissions() {

        val missing = permissions.filter {

            ContextCompat.checkSelfPermission(
                activity,
                it
            ) != PackageManager.PERMISSION_GRANTED

        }


        if (missing.isNotEmpty()) {

            ActivityCompat.requestPermissions(

                activity,

                missing.toTypedArray(),

                1001

            )

        }

    }

}