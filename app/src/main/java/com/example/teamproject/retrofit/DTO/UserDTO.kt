package com.example.teamproject.retrofit.DTO

/**
 * GET or POST 시 받아오는 JSON의 형식을 잘보고 Key 이름과 Key 타입을 의미하는 변수의 이름은 항상 같아야함.
 * EX) test 코드에서는 /user로 요청시 {name: row[0]}으로 보내주니 row[0]을 받아서 사용하고 싶으면 변수 이름을 name으로 사용
 */

data class UserDTO(
    var name: String,
    var pw: String,
)