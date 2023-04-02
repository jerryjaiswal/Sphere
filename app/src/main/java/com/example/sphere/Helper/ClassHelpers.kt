package com.example.sphere.Helper

import android.app.Activity
import android.app.AlertDialog

import android.content.Context
import android.content.res.Configuration

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


class ClassHelpers {

    companion object {
        fun showAlertDialog(context: Context) {
            AlertDialog.Builder(context).setTitle("Do you want to exit?")
                .setPositiveButton("No") { dialog, which ->
                    dialog.dismiss()
                }
                .setNegativeButton("Yes") { dialog, which ->

                    val preferences =
                        context.getSharedPreferences("Starter", AppCompatActivity.MODE_PRIVATE)
                    var editor = preferences.edit()
                    editor.putString("firstTimeOpening", "yes").apply()
                    (context as Activity).finish()
                }.create().show()
        }
    }

    class DarkMode {
        companion object {
            fun darkModeOn(context: Context) {

                var nightMode =
                    context.resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)

                when (nightMode) {
                    Configuration.UI_MODE_NIGHT_YES -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    }
                    Configuration.UI_MODE_NIGHT_NO -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    }
                    Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    }
                }

            }
        }
    }


    class Exit {
        companion object {
            fun exitApp(context: Context) {
                AlertDialog.Builder(context).setTitle("Do you want to exit?")
                    .setPositiveButton("No") { dialog, which ->
                        dialog.dismiss()
                    }
                    .setNegativeButton("Yes") { dialog, which ->
                        (context as Activity).finish()
                    }.create().show()
            }
        }
    }
}

