package com.example.teamproject.retrofit.DTO

import com.google.gson.annotations.SerializedName
import java.util.Objects

data class MapDTO(
    @SerializedName("시설명") val buildName: HashMap<Int, String>,
    @SerializedName("도로명주소") val roadAddress: HashMap<Int, String>,
    @SerializedName("카테고리2") val categoryTwo: HashMap<Int, String>,
    @SerializedName("카테고리3") val categoryThree: HashMap<Int, String>,
    @SerializedName("시도명칭") val region: HashMap<Int, String>,
    @SerializedName("휴무일") val holidays: HashMap<Int, String>,
    @SerializedName("반려동물 동반 가능정보") val withPet: HashMap<Int, String>,
    @SerializedName("위도") val latitude: HashMap<Int, String>,
    @SerializedName("경도") val longitude: HashMap<Int, String>,
    @SerializedName("운영시간") val operate: HashMap<Int, String>,
    @SerializedName("전화번호") val call: HashMap<Int, String>,
)