package com.example.sphere.Ui.Intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sphere.ConverterActivity
import com.example.sphere.Helper.ClassHelpers
import com.example.sphere.R
import com.example.sphere.Ui.Fragment.currency
import com.example.sphere.Ui.Fragment.news
import com.example.sphere.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(currency())
        var count = 0
        binding.rightArrowIntro.setOnClickListener {
            if (count == 0) {
                binding.currencyDot.setImageResource(R.drawable.ic_unselected_dot)
                binding.newsDot.setImageResource(R.drawable.ic_selected_dot)
                replaceFragment(news())
                count += 1
            } else {
                startActivity(Intent(this, ConverterActivity::class.java))
                finish()
            }
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }

    override fun onBackPressed() {
        ClassHelpers.showAlertDialog(this)
    }
}