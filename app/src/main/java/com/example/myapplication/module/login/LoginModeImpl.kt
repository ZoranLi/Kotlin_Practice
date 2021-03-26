package com.example.myapplication.module.login

import android.content.Context
import com.example.myapplication.api.WanAPI
import com.example.myapplication.data.LoginResponse
import com.example.myapplication.module.login.inter.LoginModule
import com.example.myapplication.module.login.inter.LoginPresenter
import com.example.myapplication.net.APIClient
import com.example.myapplication.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

//模型层的实现
class LoginModeImpl : LoginModule {
    override fun cancelRequest() {

    }

    override fun login(
        context: Context,
        userName: String,
        password: String,
        listener: LoginPresenter.OnLoginListener
    ) {
        val wanAPI = APIClient.instance.instanceRetrofit(WanAPI::class.java);
        wanAPI.loginAction(userName, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : APIResponse<LoginResponse>(context) {
                override fun success(data: LoginResponse?) {
                    listener.loginSuccess(data);
                }

                override fun failure(errorMsg: String?) {
                    listener.loginFailure(errorMsg);
                }
            })
    }
}