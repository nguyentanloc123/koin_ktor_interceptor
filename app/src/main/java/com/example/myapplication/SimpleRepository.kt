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
            var datalogin = "{\n" +
                    "    \"code\": \"ERROR\",\n" +
                    "    \"success\": false,\n" +
                    "    \"message\": \"Invalid Email or Password.\",\n" +
                    "    \"messages\": [\n" +
                    "        \"Invalid Email or Password.\"\n" +
                    "    ]\n" +
                    "}"
//            val response: ApiResult<LeadFollowUp> = apiService.post(url)
            var data = Json.decodeFromString<ApiResult<LeadFollowUp>>(datalogin)
            Log.d("Success", data.toString())
//            if (response.success == true) {
//                emit(data)
//            }
        } catch (e: Exception) {
            Log.d("ExceptionTest", e.message.toString())
        }
    }
}