package com.example.myapplication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    var id: Int = 0,
    var contact: String = "",
    var accessToken: String = "",
    var refreshToken: String = "",
    var apiKey: String = "",
    var ssoToken: String = "",
    var appId: String = "appId"
)