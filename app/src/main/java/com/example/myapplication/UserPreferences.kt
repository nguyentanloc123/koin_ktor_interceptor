package com.example.myapplication


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences(
    context: Context
) {
    companion object {
        private const val DATA_STORE_NAME = "user_data_store"
        private val KEY_AUTH = intPreferencesKey("key_auth")
    }

    private val appContext = context.applicationContext

    //    private val dataStore: DataStore<Preferences>
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "accesstoken")

    val EXAMPLE_COUNTER = stringPreferencesKey("example_counter")
    val authToken: Flow<String> = context.dataStore.data
        .map { preferences ->
            // No type safety.
            preferences[EXAMPLE_COUNTER] ?: 0
        } as Flow<String>

    suspend fun saveAuthToken(authToken: String) {
        appContext.dataStore.edit { settings ->
            val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
            settings[EXAMPLE_COUNTER] = authToken
        }
    }
//    val authToken: Flow<String?>
//        get() = dataStore.data.map { preferences ->
//            preferences[KEY_AUTH]
//        }

//    suspend fun saveAuthToken(authToken: String) {
//        dataStore.edit { preferences ->
//            preferences[KEY_AUTH] = authToken
//        }
//    }
}