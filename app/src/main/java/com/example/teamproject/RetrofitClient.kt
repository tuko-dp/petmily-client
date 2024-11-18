package com.example.teamproject

import android.util.Log
import com.example.teamproject.retrofit.GetInterface
import com.example.teamproject.retrofit.MapInterface
import com.example.teamproject.retrofit.UserInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

object RetrofitClient {
    /**
     * 현재 백엔드 서버는 FastAPI로 개발중므로 각자 서버에 돌리는 서버 포트에 맞춰서 host번호와 port번호 변경하세요.
     * Ex) Terminal: uvicorn Main:app --host host번호 --port port번호
     * 그 후 하단 BASE_URL 상수에 있는 번호에 맞춰서 변경 후 꼭 포트번호 뒤에 "/"로 닫아주세요.
     * **/
    private val BASE_URL: String = "http://10.220.240.223:8000/"

    val getUserAPI = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserInterface::class.java)

    val getMapAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MapInterface::class.java)

    val postSiginAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserInterface::class.java)
}