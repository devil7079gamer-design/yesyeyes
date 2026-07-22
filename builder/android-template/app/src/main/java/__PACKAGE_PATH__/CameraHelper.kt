package __PACKAGE_NAME__

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.net.Uri


class CameraHelper(
    private val activity: Activity
) {


    private var imageUri: Uri? = null


    fun openCamera() {


        val intent = Intent(
            MediaStore.ACTION_IMAGE_CAPTURE
        )


        activity.startActivityForResult(

            intent,

            3001

        )


    }


    fun getImageUri(): Uri? {


        return imageUri


    }


}