package com.example.myapplication

import android.util.Log
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class SimpleRepoqsitory(val apiService: ApiService) {
    suspend fun getFollowUp(): Flow<ApiResult<LeadFollowUp>> = flow {
        val url = "${MainActivity.BaseUrl}/leads/follow-up/new-activities"
        //return flow {
        try {
            val response: LeadFollowUp = apiService.get(url)
            val response1 = apiService.get<LeadFollowUp>(url)
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