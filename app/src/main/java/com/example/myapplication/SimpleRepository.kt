package com.example.myapplication

import android.util.Log
import io.ktor.client.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class SimpleRepository(val apiService: ApiService) {

    suspend fun getFollowUp(): Flow<ApiResult<LeadFollowUp>> = flow {
        val url = "${MainActivity.BaseUrl}/leads/follow-up/new-activities"
        try {
            val response: ApiResult<LeadFollowUp> = apiService.get(url)
            var data = Json.decodeFromString<ApiResult<LeadFollowUp>>(response.toString())
            Log.d("Success", data.toString())
            if (response.success == true) {
                emit(data)
            }
        } catch (e: Exception) {
            Log.d("ExceptionTest", e.message.toString())
        }
    }


}