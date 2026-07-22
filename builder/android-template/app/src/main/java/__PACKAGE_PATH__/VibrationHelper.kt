package __PACKAGE_NAME__

import android.content.Context
import android.os.Vibrator
import android.os.VibrationEffect
import android.os.Build


class VibrationHelper(
    private val context: Context
) {


    fun vibrate(
        duration: Long = 100
    ) {


        val vibrator =
            context.getSystemService(
                Context.VIBRATOR_SERVICE
            ) as Vibrator


        if (Build.VERSION.SDK_INT >= 26) {


            vibrator.vibrate(

                VibrationEffect.createOneShot(

                    duration,

                    VibrationEffect.DEFAULT_AMPLITUDE

                )

            )


        } else {


            @Suppress("DEPRECATION")

            vibrator.vibrate(
                duration
            )


        }


    }


}