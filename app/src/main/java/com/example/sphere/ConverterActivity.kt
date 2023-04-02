package com.example.sphere

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sphere.Helper.ClassHelpers
import com.example.sphere.databinding.ActivityConverterBinding

class ConverterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConverterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConverterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newsIcon.setOnClickListener {
            startActivity(Intent(this, NewsActivity::class.java))
            finish()
        }

        binding.converterDarkMode.setOnClickListener {
            ClassHelpers.DarkMode.darkModeOn(this)
        }
    }

    override fun onBackPressed() {
        ClassHelpers.Exit.exitApp(this)
    }
}