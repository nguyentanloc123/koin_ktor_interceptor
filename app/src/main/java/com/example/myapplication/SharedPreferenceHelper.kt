package com.example.myapplication

import android.annotation.SuppressLint
import androidx.preference.PreferenceManager


class SharedPreferenceHelper {

    private val APP_NAME = "Koltin"

    fun getSharedPreferenceHelper(key: String): String? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance())
        return prefs.getString(key, "")
    }

    @SuppressLint("CommitPrefEdits")
    fun setSharedPreferenceHelper(key: String, data: String) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance())
        with(prefs.edit()) {
            putString(key, data)
            apply()
        }
    }
}