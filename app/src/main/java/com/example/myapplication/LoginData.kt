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
//@Serializable
//data class UserD(
//    var id: Int = 0,
//    var contact: String = "",
//    var accessToken: String = "",
//    var refreshToken: String = "",
//    @SerialName("apiKey")
//    var apiKey: String = "",
//    @SerialName("ssoToken")
//    var ssoToken: String = "",
//    @SerialName("apiKey")
//    var appId: String = "appId"
//)