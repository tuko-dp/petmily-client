package com.example.teamproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.WindowCompat
import com.example.teamproject.retrofit.DTO.MapDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        노치바 대응
//        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main2)

        var btn1 = findViewById<LinearLayout>(R.id.dst)

        btn1.setOnClickListener() {
            var intent = Intent(this, PetCompanionPlace::class.java)
            startActivity(intent)
        }

    }
}