package com.example.teamproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.teamproject.retrofit.DTO.MapDTO
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList
import javax.security.auth.callback.Callback

private fun TextView.setText(buildName: Object, d: Double) {

}

class PetCompanionPlace : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_companion_place)

        var textView = findViewById<TextView>(R.id.text_view)

        RetrofitClient.getMapAPI.getMapInfo().enqueue(object: Call<MapDTO>,
            retrofit2.Callback<MapDTO> {
            override fun onResponse(call: Call<MapDTO>, response: Response<MapDTO>) {
                val body: Object = response.body()!!.buildName
                if(response.isSuccessful) {
                    Log.i("API 호출", "result = ${body}")
                    textView.setText(body.toString())
                }
            }

            override fun onFailure(call: Call<MapDTO>, t: Throwable) {
                Log.e("API 호출 에러", "err: ${t.message}")
            }

            override fun clone(): Call<MapDTO> {
                TODO("Not yet implemented")
            }

            override fun execute(): Response<MapDTO> {
                TODO("Not yet implemented")
            }

            override fun isExecuted(): Boolean {
                TODO("Not yet implemented")
            }

            override fun cancel() {
                TODO("Not yet implemented")
            }

            override fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun request(): Request {
                TODO("Not yet implemented")
            }

            override fun timeout(): Timeout {
                TODO("Not yet implemented")
            }

            override fun enqueue(callback: retrofit2.Callback<MapDTO>) {
                TODO("Not yet implemented")
            }

        })
    }
}