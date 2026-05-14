package com.example.prathamchikitse.language

import android.content.Context
import java.util.Locale

object LanguageManager {
    private const val PREFS_NAME = "app_prefs"
    private const val KEY_LANGUAGE = "selected_language"

    fun getSelectedLanguage(context: Context): AppLanguage {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return when (prefs.getString(KEY_LANGUAGE, AppLanguage.ENGLISH.name)) {
            AppLanguage.KANNADA.name -> AppLanguage.KANNADA
            else -> AppLanguage.ENGLISH
        }
    }

    fun toggleLanguage(context: Context): AppLanguage {
        val next = when (getSelectedLanguage(context)) {
            AppLanguage.ENGLISH -> AppLanguage.KANNADA
            AppLanguage.KANNADA -> AppLanguage.ENGLISH
        }
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(KEY_LANGUAGE, next.name).apply()
        return next
    }

    fun getToggleButtonText(current: AppLanguage): String {
        return if (current == AppLanguage.ENGLISH) "ಕನ್ನಡ" else "English"
    }

    fun localeFor(language: AppLanguage): Locale {
        return if (language == AppLanguage.KANNADA) Locale.forLanguageTag("kn-IN") else Locale.ENGLISH
    }
}

