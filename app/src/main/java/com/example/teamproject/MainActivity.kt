package com.example.teamproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    val TAG: String = "HTTP_GET_USER"
    val ERR_TAG: String = "ERR_HTTP_GET_USER"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MainActivity2::class.java)

        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(intent)
        }, 3000)





//        loginBtn.setOnClickListener() {
////            RetrofitClient.getUserAPI.getUserInformation().enqueue(object : Callback<UserDTO> {
////                override fun onResponse(call: Call<UserDTO>, response: Response<UserDTO>) {
////                    val body: String? = response.body()?.name
////                    if(response.isSuccessful) {
////                        Log.i(TAG, "${response.body()?.name}")
////                        Log.i(TAG, "${response.body()?.pw}")
////                        name.setText("${response.body()?.name}")
////                        pw.setText("${response.body()?.pw}")
////                    }
////                }
////
////                override fun onFailure(call: Call<UserDTO>, t: Throwable) {
////                    Log.i(ERR_TAG, "onFailure ${t.message}")
////                }
////            })
//            val intent = Intent(this, MainActivity2::class.java)
//            startActivity(intent)
//        }
    }

}