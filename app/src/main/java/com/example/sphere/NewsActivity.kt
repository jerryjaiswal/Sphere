package com.example.sphere

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sphere.Helper.ClassHelpers
import com.example.sphere.Ui.Fragment.ApiNews
import com.example.sphere.Ui.Fragment.SavedNews
import com.example.sphere.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//after we get the data from the api then we have to show the apiNews fragment
        replaceFragment(ApiNews())
        var count = 0

        binding.currencyIcon.setOnClickListener {
            startActivity(Intent(this, ConverterActivity::class.java))
            finish()
        }

        binding.bookmark.setOnClickListener {
            if (count == 0) {
                binding.bookmark.setImageResource(R.drawable.ic_bookmark_selected)
                replaceFragment(SavedNews())
                count++
            } else {
                binding.bookmark.setImageResource(R.drawable.ic_bookmark_unselected)
                replaceFragment(ApiNews())
                count--
            }

        }

        binding.newsDarkMode.setOnClickListener {
            ClassHelpers.DarkMode.darkModeOn(this)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.newsFrameLayout, fragment).commit()
    }

    override fun onBackPressed() {
        ClassHelpers.Exit.exitApp(this)
    }
}