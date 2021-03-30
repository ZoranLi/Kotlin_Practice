package com.example.myapplication.net

fun main() {
    login("andy", "123") {
        if (it)
            print("登录成功")
        else
            print("登录失败")
    }
    val name: String = "222";
    name.let{
    }
}

fun login(username: String, pass: String, loginResponse: (Boolean) -> Unit) {
    return loginEngin(username, pass, loginResponse)
};

fun loginEngin(username: String, pass: String, loginResponse: (Boolean) -> Unit) {
    if (username == "andy" && pass == "123") {
        loginResponse(true)
    } else
        loginResponse(false)
}