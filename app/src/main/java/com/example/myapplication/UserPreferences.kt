package com.example.myapplication


import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import kotlin.random.Random
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "accesstoken")

class UserPreferences(
    context: Context
) {
    companion object {
        private const val DATA_STORE_NAME = "user_data_store"
    }
    var loggedInScope: CoroutineScope = CoroutineScope(Dispatchers.Default)

    private object PreferenceKeys {
        val name = stringPreferencesKey("accesstoken")
    }
    private val appContext = context.applicationContext
//    private val dataStore: DataStore<Preferences>

    suspend fun saveAuthToken(authToken: String) {
        appContext.dataStore.edit { settings ->
            settings[PreferenceKeys.name] = Random.nextInt(100000000).toString()
            Log.d("test",settings.toString())
        }
    }
    val authToken: Flow<String> = context.dataStore.data
        .catch { exception ->
            if(exception is IOException){
                Log.d("DataStore", exception.message.toString())
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }
        .map { preference ->
            val myName = preference[PreferenceKeys.name] ?: "none"
            myName
        }
}