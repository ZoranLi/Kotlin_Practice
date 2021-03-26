package com.example.myapplication.module.login.inter

import android.content.Context
import com.example.myapplication.data.LoginResponse

//Presenter
interface LoginPresenter {
    //    登录的动作
    fun loginAction(context: Context,username:String,passwrod:String);



    //接口回调

    interface OnLoginListener{
        fun loginSuccess(loginBean: LoginResponse?);

        fun loginFailure(errorMsg: String?);
    }

}