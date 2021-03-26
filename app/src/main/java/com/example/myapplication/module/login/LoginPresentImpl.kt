package com.example.myapplication.module.login

import android.content.Context
import com.example.myapplication.data.LoginResponse
import com.example.myapplication.module.login.inter.LoginModule
import com.example.myapplication.module.login.inter.LoginPresenter
import com.example.myapplication.module.login.inter.LoginView

//presenter的实现
class LoginPresentImpl constructor(var loginView: LoginView?) : LoginPresenter,
    LoginPresenter.OnLoginListener {

    //需要module 请求服务器

    //需要v更新activity/fragment  loginView

    private val loginMode: LoginModule = LoginModeImpl();


    override fun loginAction(context: Context, username: String, passwrod: String) {
        //校验数据
        loginMode.login(context, username, passwrod, this);
    }

    override fun attachView() {

    }

    override fun unAttachView() {
        loginView = null;
        loginMode.cancelRequest();
    }

    //    接受Model的结果集
    override fun loginSuccess(loginBean: LoginResponse?) {
        loginView?.loginSuccess(loginBean);
    }

    override fun loginFailure(errorMsg: String?) {
        loginView?.loginFailure(errorMsg);
    }

}