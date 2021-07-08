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