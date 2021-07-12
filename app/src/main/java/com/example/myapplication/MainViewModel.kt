package com.example.myapplication

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import io.ktor.client.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = UserPreferences(application)

    val readFromDataStore = repository.authToken.asLiveData()
}