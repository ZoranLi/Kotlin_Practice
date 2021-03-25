package com.example.myapplication.data

/*
"data": {
"admin": false,
"chapterTops": [],
"coinCount": 0,
"collectIds": [],
"email": "",
"icon": "",
"id": 73648,
"nickname": "derry",
"password": "",
"publicName": "derry",
"token": "",
"type": 0,
"username": "derry"
}
 */
data class LoginResponse(
    val admin: Boolean,
    val chapterTops: List<*>,
    val coinCount: Int,
    val collectIds: List<*>,
    val email: String?,
    val icon: String?,
    val id: Long,
    val nickname: String,
    val password: String?,
    val publicName: String,
    val token: String?,
    val type: Int,
    val username: String?
);