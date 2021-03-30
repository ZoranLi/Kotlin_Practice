package com.example.myapplication.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIClient {
    //对象表达式
//   1、创建一个继承自某个（或某些）类型的匿名类的对象
//    2、
    private object Holder {
        val INSTANCE = APIClient();
    }

    //类内部的对象声明可以用 companion 关键字标记：
    //该伴生对象的成员可通过只使用类名作为限定符来调用：
    //即使伴生对象的成员看起来像其他语言的静态成员，在运行时他们仍然是真实对象的实例成员
    companion object {
        val instance = Holder.INSTANCE;
    }

    fun <T> instanceRetrofit(apiInterface: Class<T>): T {
        val okHttpClient = OkHttpClient()
            .newBuilder()
            .readTimeout(10000L, TimeUnit.SECONDS)
            .writeTimeout(10000L, TimeUnit.SECONDS)
            .connectTimeout(10000L, TimeUnit.SECONDS)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")
            .client(okHttpClient.build())

            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        return retrofit.create(apiInterface);
    }
}