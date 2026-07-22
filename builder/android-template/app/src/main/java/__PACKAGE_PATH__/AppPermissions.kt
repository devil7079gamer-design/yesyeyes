package __PACKAGE_NAME__

import android.Manifest


object AppPermissions {


    val CAMERA = arrayOf(

        Manifest.permission.CAMERA

    )


    val LOCATION = arrayOf(

        Manifest.permission.ACCESS_FINE_LOCATION,

        Manifest.permission.ACCESS_COARSE_LOCATION

    )


    val MEDIA = arrayOf(

        Manifest.permission.READ_MEDIA_IMAGES,

        Manifest.permission.READ_MEDIA_VIDEO

    )


    val ALL = arrayOf(

        Manifest.permission.CAMERA,

        Manifest.permission.RECORD_AUDIO,

        Manifest.permission.ACCESS_FINE_LOCATION,

        Manifest.permission.ACCESS_COARSE_LOCATION

    )


}