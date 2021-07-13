package com.example.myapplication

import kotlinx.serialization.Serializable

@Serializable
data class ApiResult<T>(
    var code: String? = null,
    var success: Boolean? = null,
    var data: List<T>? = null,
)

@Serializable
data class LeadFollowUp(
    var id: Int? = null,
    var name: String? = null
)
@Serializable
class EmptyBody()