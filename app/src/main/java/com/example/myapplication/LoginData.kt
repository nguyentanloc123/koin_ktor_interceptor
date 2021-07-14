package com.example.myapplication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class LoginData(
    @SerialName("code")
    var code: String = "callithome",
    @SerialName("email")
    var email: String = "info@callithome.com",
    @SerialName("password")
    var password: String = "stoneipa"
)
@Serializable
data class UserData(
    @SerialName("id")
    var id: Int = 0,
    @SerialName("contact")
    var contact: String = "",
    @SerialName("accessToken")
    var accessToken: String = "",
    @SerialName("refreshToken")
    var refreshToken: String = "",
    @SerialName("apiKey")
    var apiKey: String = "",
    @SerialName("ssoToken")
    var ssoToken: String = "",
    @SerialName("appId")
    var appId: String = ""
)