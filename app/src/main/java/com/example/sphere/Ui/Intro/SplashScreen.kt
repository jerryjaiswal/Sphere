package com.example.sphere.Ui.Intro


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import android.view.View
import com.example.sphere.ConverterActivity
import com.example.sphere.Helper.ClassHelpers
import com.example.sphere.R
import com.example.sphere.databinding.ActivitySplashScreenBinding


class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var firstTime: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = getSharedPreferences("Starter", MODE_PRIVATE)
        firstTime = preferences.getString("firstTimeOpening", "yes").toString()
        val intent = Intent(this, IntroActivity::class.java)

        if (firstTime == "yes") {
//            user has installed the app for the first time so we execute this code
            val editor = preferences.edit()
            editor.putString("firstTimeOpening", "no").apply()

            binding.getStarted.setOnClickListener {
                startActivity(intent)
                finish()
            }

        } else {
//else we execute this code
            binding.getStarted.visibility = View.GONE
            startIntent()
        }

    }

    override fun onBackPressed() {
        if (firstTime == "yes")
            ClassHelpers.showAlertDialog(this)
        else super.onBackPressed()
    }


    private fun startIntent() {

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, ConverterActivity::class.java))
            finish()
        }, 3000)
    }

}