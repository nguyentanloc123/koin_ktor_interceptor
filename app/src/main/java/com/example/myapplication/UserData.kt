package com.example.myapplication

import android.os.Parcelable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserData(
    @SerialName("id")
    var id: Int? = null,
    @SerialName("accessToken")
    var accessToken: String? = null,
)