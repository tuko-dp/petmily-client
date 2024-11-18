package com.example.teamproject.retrofit

import com.example.teamproject.retrofit.DTO.MapDTO
import retrofit2.Call
import retrofit2.http.GET

interface MapInterface {
    @GET("/map")
    fun getMapInfo(): Call<MapDTO>
}