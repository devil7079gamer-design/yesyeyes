package __PACKAGE_NAME__

import android.content.Context
import java.io.File


object AppFileManager {


    fun saveText(

        context: Context,

        name: String,

        content: String

    ) {


        val file = File(

            context.filesDir,

            name

        )


        file.writeText(

            content

        )


    }


    fun readText(

        context: Context,

        name: String

    ): String {


        val file = File(

            context.filesDir,

            name

        )


        return if (

            file.exists()

        ) {


            file.readText()


        } else {


            ""


        }


    }


    fun delete(

        context: Context,

        name: String

    ) {


        val file = File(

            context.filesDir,

            name

        )


        if (

            file.exists()

        ) {


            file.delete()


        }


    }


}