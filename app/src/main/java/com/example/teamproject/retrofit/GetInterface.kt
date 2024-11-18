package com.example.teamproject.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface GetInterface {
    @GET("/")
    fun getMain(): Call<GetBody>
}