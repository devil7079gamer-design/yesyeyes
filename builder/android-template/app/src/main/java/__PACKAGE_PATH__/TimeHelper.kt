package __PACKAGE_NAME__

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


object TimeHelper {


    fun currentTime(): String {


        val format = SimpleDateFormat(

            "yyyy-MM-dd HH:mm:ss",

            Locale.getDefault()

        )


        return format.format(

            Date()

        )


    }


    fun timestamp(): Long {


        return System.currentTimeMillis()


    }


}