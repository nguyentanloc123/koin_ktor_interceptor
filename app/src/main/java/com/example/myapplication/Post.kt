package com.example.myapplication

@kotlinx.serialization.Serializable
data class ApiResult<T>(
    var code: String? = null,
    var success: Boolean? = null,
    var data: List<T> ? = null,
)
@kotlinx.serialization.Serializable
data class LeadFollowUp(
    var id: Int? = null,
    var name: String? = null
)