package com.example.myapplication.module.login.inter

import com.example.myapplication.data.LoginResponse

interface LoginView {

//把结果显示在activity和Fragment
    fun loginSuccess(loginBean: LoginResponse?);


    fun loginFailure(errorMsg: String?);
}