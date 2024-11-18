package com.example.teamproject.retrofit

import com.google.gson.annotations.SerializedName

data class PostSignin(
    @SerializedName("email")
    val email: String,
    @SerializedName("pw")
    val pw: String
)
