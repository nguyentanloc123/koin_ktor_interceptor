package com.example.myapplication

import android.util.Log
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class SimpleRepoqsitory(val apiService: ApiService) {
    suspend fun getFollowUp() {
        val url = "${MainActivity.BaseUrl}/leads/follow-up/new-activities"
        try {
            var temp: EmptyBody = EmptyBody()
            val response: ApiResult<LeadFollowUp> = apiService.get(url)
            var data = Json.decodeFromString<ApiResult<LeadFollowUp>>(response.toString())
            Log.d("Success", data.toString())
//            if (response.status.isSuccess()) {
//                emit(data)
//            }
        } catch (e: Exception) {
            Log.d("ExceptionTest", e.message.toString())
        }
    }

}