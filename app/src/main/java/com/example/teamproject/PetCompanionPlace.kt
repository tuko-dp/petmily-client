package com.example.teamproject

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ListView
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.view.size
import com.example.teamproject.retrofit.DTO.MapDTO
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Response

class PetCompanionPlace : AppCompatActivity() {

    fun replacementNull(word: String): String {
        return if (word == "null") {
            "데이터 X"
        } else {
            word
        }
    }

//  키토크 선택에 띠라 필터링된 데이터 제공
    fun filterKeytalk() {
        val keyCafe = findViewById<TextView>(R.id.key_cafe)
        val keyDrug = findViewById<TextView>(R.id.key_drug)
        val keyHospital = findViewById<TextView>(R.id.key_hospital)
        val keyBeauty = findViewById<TextView>(R.id.key_beauty)
        val keyArt = findViewById<TextView>(R.id.key_art)
        val keyShop = findViewById<TextView>(R.id.key_shop)


    }

    fun filteringPhoto(category: String): Drawable {
        if (category == "동물병원") {
            return ContextCompat.getDrawable(this, R.drawable.hospital)!!
        } else if(category == "카페") {
            return ContextCompat.getDrawable(this, R.drawable.cafe)!!
        } else if(category == "반려동물용품") {
            return ContextCompat.getDrawable(this, R.drawable.petshop)!!
        } else if(category == "미술관") {
            return ContextCompat.getDrawable(this, R.drawable.artgall)!!
        } else if(category == "동물약국") {
            return ContextCompat.getDrawable(this, R.drawable.drug)!!
        }
        else {
            return ContextCompat.getDrawable(this, R.drawable.cat_muong)!!
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_companion_place)

        var listView = findViewById<ListView>(R.id.shop_list) as ListView
        val adapter: ItemLayout = ItemLayout()

        var intent = Intent(this, MapActivity::class.java)

        var searchView = findViewById<androidx.appcompat.widget.SearchView>(R.id.search)
//        searchView.setTextSize(1F)

        RetrofitClient.getMapAPI.getMapInfo().enqueue(object: Call<MapDTO>,
            retrofit2.Callback<MapDTO> {
            override fun onResponse(call: Call<MapDTO>, response: Response<MapDTO>) {
                val body: HashMap<Int, String> = response.body()!!.buildName
                val road: HashMap<Int, String> = response.body()!!.roadAddress
//                val category2 = response.body()!!.categoryTwo
                val category3:HashMap<Int, String> = response.body()!!.categoryThree
                val region = response.body()!!.region
                var operate: HashMap<Int, String> = response.body()!!.operate
                var call: HashMap<Int, String> = response.body()!!.call
                if(response.isSuccessful) {
                    Log.i("API 호출", "result = ${body}")

                    for(i: Int in 1..body.size) {
                        adapter.addItem(body[i].toString(), category3[i].toString(), road[i].toString(), "운영정보: ${operate[i].toString()}", "연락처: ${replacementNull(call[i].toString())}", filteringPhoto(category3[i].toString()))
                    }
                }
                listView.adapter = adapter

                listView.onItemClickListener = AdapterView.OnItemClickListener() { parent, v, positon, id ->
                    val item = parent.getItemAtPosition(positon) as ListViewItem
                    val facilities = item.facilities
                    val category = item.category
                    val location = item.location
                    val operate = item.operate
                    val call = item.call

                    startActivity(intent)
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