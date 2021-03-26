package com.example.myapplication.module.login.inter

import android.content.Context

interface LoginModule {
    //    取消请求
    fun cancelRequest();

    fun login(
        context: Context,
        userName: String,
        password: String,
        listener: LoginPresenter.OnLoginListener
    );
}