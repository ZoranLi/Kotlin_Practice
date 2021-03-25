package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.api.WanAPI
import com.example.myapplication.data.LoginResponse
import com.example.myapplication.data.LoginResponseWrapper
import com.example.myapplication.net.APIClient
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val wanAPI = APIClient.instance.instanceRetrofit(WanAPI::class.java);
        wanAPI.loginAction("derry","123456")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Consumer<LoginResponseWrapper<LoginResponse>> {
                override fun accept(t: LoginResponseWrapper<LoginResponse>?) {
                    Log.e(this@MainActivity.javaClass.name, Gson().toJson(t?.data));
                }
            });
    }
}