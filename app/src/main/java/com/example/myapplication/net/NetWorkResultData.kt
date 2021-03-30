package com.example.myapplication.net

import android.os.Handler
import android.os.Looper
import android.os.Message
import okhttp3.Call
import okhttp3.Response
import java.io.IOException

abstract class NetWorkResultData : okhttp3.Callback {
    override fun onFailure(call: Call, e: IOException) {
//        requestError(e.message.toString())
        Handler(Looper.getMainLooper(), object : Handler.Callback {
            override fun handleMessage(msg: Message): Boolean {
                e.message?.let {
                    requestError(it);//如果不为null 就执行
                }
                return false;
            };
        }).sendEmptyMessage(0);

    }

    override fun onResponse(call: Call, response: Response) {
        Handler(Looper.getMainLooper(),Handler.Callback {
            requestSuccess(response)
            false
        });
    }

    abstract fun requestError(info: String);
    abstract fun requestSuccess(response: Response);
}