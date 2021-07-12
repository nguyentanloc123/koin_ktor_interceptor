package com.example.myapplication


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
var loggedInScope: CoroutineScope = CoroutineScope(Dispatchers.Default)
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "access_token",scope = loggedInScope)
class UserPreferences(
    context: Context
) {
    companion object {
        private const val DATA_STORE_NAME = "user_data_store"
        private val KEY_AUTH = stringPreferencesKey("key_auth")
    }
    private val appContext = context.applicationContext
    val EXAMPLE_KEY = stringPreferencesKey("key_auth")
    val EXAMPLE_COUNTER = stringPreferencesKey("example_counter")
    val authToken: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[EXAMPLE_COUNTER] ?: ""
        }

    suspend fun saveAuthToken(authToken: String) {
        appContext.dataStore.edit { preferences ->
            preferences.clear()
            val currentCounterValue = preferences[EXAMPLE_COUNTER] ?: ""
            preferences[EXAMPLE_COUNTER] = authToken
        }
    }


}