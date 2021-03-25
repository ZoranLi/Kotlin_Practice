package com.example.myapplication.data

/**

{
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
},
"errorCode": 0,
"errorMsg": ""
}

 */
data class LoginResponseWrapper<T>(val data:T,val errorCode:Int,val errorMsg:String?);