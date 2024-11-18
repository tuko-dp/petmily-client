package com.example.teamproject.retrofit

import com.example.teamproject.retrofit.DTO.UserDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface UserInterface {
    @GET("/user")
    fun getUserInformation(): Call<UserDTO>

    @POST("/user/signin")
    fun postSignin(): Call<PostSignin>
}