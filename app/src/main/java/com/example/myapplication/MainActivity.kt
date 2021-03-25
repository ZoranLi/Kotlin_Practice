package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.api.WanAPI
import com.example.myapplication.data.LoginResponse
import com.example.myapplication.data.LoginResponseWrapper
import com.example.myapplication.net.APIClient
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_login.setOnClickListener(View.OnClickListener {
            when (it.id) {
                R.id.tv_login -> {
                    val wanAPI = APIClient.instance.instanceRetrofit(WanAPI::class.java);
                    wanAPI.loginAction("derry", "123456")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(object : Consumer<LoginResponseWrapper<LoginResponse>> {
                            override fun accept(t: LoginResponseWrapper<LoginResponse>?) {
                                Log.e(this@MainActivity.javaClass.name, Gson().toJson(t?.data));
                                Toast.makeText(this@MainActivity, "登录成功", Toast.LENGTH_SHORT).show()
                            }
                        })
                }
                else -> {

                }
            }
        })

    }
}