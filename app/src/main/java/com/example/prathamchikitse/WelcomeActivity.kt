package com.example.prathamchikitse

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prathamchikitse.databinding.ActivityWelcomeBinding
import com.example.prathamchikitse.language.AppLanguage
import com.example.prathamchikitse.language.LanguageManager

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding
    private var currentLanguage: AppLanguage = AppLanguage.ENGLISH

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentLanguage = LanguageManager.getSelectedLanguage(this)
        applyLanguageTexts(currentLanguage)

        binding.languageToggleButton.setOnClickListener {
            currentLanguage = LanguageManager.toggleLanguage(this)
            applyLanguageTexts(currentLanguage)
        }

        binding.enterAppButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun applyLanguageTexts(language: AppLanguage) {
        binding.languageToggleButton.text = LanguageManager.getToggleButtonText(language)
        binding.appNameText.text = if (language == AppLanguage.KANNADA) {
            "ಪ್ರಥಮ-ಚಿಕಿತ್ಸೆ"
        } else {
            "Pratham-Chikitse"
        }
    }
}

