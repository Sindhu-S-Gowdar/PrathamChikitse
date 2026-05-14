package com.example.prathamchikitse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prathamchikitse.databinding.ActivityMainBinding
import com.example.prathamchikitse.language.AppLanguage
import com.example.prathamchikitse.language.LanguageAwareScreen
import com.example.prathamchikitse.language.LanguageManager
import com.example.prathamchikitse.ui.aicheck.AiCheckFragment
import com.example.prathamchikitse.ui.home.HomeFragment
import com.example.prathamchikitse.ui.hospital.HospitalFinderFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentLanguage: AppLanguage = AppLanguage.ENGLISH

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        currentLanguage = LanguageManager.getSelectedLanguage(this)

        binding.languageToggleButton.setOnClickListener {
            currentLanguage = LanguageManager.toggleLanguage(this)
            applyLanguage(currentLanguage)
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, HomeFragment())
                .commit()
        }

        binding.bottomNav.setOnItemSelectedListener { item ->
            val selectedFragment = when (item.itemId) {
                R.id.menu_home -> HomeFragment()
                R.id.menu_hospital_finder -> HospitalFinderFragment()
                R.id.menu_ai_check -> AiCheckFragment()
                else -> null
            }
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, selectedFragment)
                    .commit()
                supportFragmentManager.executePendingTransactions()
                notifyCurrentFragment()
                true
            } else {
                false
            }
        }

        applyLanguage(currentLanguage)
    }

    private fun applyLanguage(language: AppLanguage) {
        binding.languageToggleButton.text = LanguageManager.getToggleButtonText(language)
        binding.bottomNav.menu.findItem(R.id.menu_home).title =
            if (language == AppLanguage.KANNADA) "ಮುಖಪುಟ" else "Home"
        binding.bottomNav.menu.findItem(R.id.menu_hospital_finder).title =
            if (language == AppLanguage.KANNADA) "ಆಸ್ಪತ್ರೆ ಹುಡುಕಿ" else "Hospital Finder"
        binding.bottomNav.menu.findItem(R.id.menu_ai_check).title =
            if (language == AppLanguage.KANNADA) "AI ಪರಿಶೀಲನೆ" else "AI Check"
        notifyCurrentFragment()
    }

    private fun notifyCurrentFragment() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        if (fragment is LanguageAwareScreen) {
            fragment.onLanguageChanged(currentLanguage)
        }
    }
}