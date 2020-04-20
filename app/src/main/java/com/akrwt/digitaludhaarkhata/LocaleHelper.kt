package com.akrwt.digitaludhaarkhata

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.preference.PreferenceManager
import java.util.*

class LocaleHelper {
    private val selectedLanguage = "Locale.Helper.Selected.Language"


    fun onAttach(context: Context): Context {
        val lang = getPersistedData(context, Locale.getDefault().language)
        return setLocale(context, lang)
    }

    fun onAttach(context: Context, defaultLanguage: String): Context {
        val lang = getPersistedData(context, defaultLanguage)
        return setLocale(context, lang)
    }

     fun setLocale(context: Context, lang: String): Context {
        persist(context, lang)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            return updateResources(context, lang)
        return updateResourceLegacy(context, lang)

    }

    @TargetApi(Build.VERSION_CODES.N)
    private fun updateResources(context: Context, lang: String): Context {
        val locale = Locale(lang)
        Locale.setDefault(locale)

        val config = context.resources.configuration
        config.setLocale(locale)
        config.setLayoutDirection(locale)

        return context.createConfigurationContext(config)
    }


    @SuppressWarnings("deprecation")
    private fun updateResourceLegacy(context: Context, lang: String): Context {
        val locale = Locale(lang)
        Locale.setDefault(locale)

        val resources = context.resources
        val config = resources.configuration
        config.locale = locale
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            config.setLayoutDirection(locale)
        }
        resources.updateConfiguration(config,resources.displayMetrics)
        return context

    }


    private fun persist(context: Context, lang: String) {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = pref.edit()
        editor.putString(selectedLanguage, lang)
        editor.apply()
    }

    private fun getPersistedData(context: Context, language: String): String {

        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        return pref.getString(selectedLanguage, language)!!

    }

}