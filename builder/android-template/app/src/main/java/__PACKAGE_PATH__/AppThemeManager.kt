package com.yesyeyes.app

import androidx.appcompat.app.AppCompatDelegate


object AppThemeManager {


    fun darkMode() {


        AppCompatDelegate.setDefaultNightMode(

            AppCompatDelegate.MODE_NIGHT_YES

        )


    }


    fun lightMode() {


        AppCompatDelegate.setDefaultNightMode(

            AppCompatDelegate.MODE_NIGHT_NO

        )


    }


    fun systemMode() {


        AppCompatDelegate.setDefaultNightMode(

            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

        )


    }


}
