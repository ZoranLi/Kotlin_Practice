package com.example.myapplication.net

import android.content.Context
import com.example.myapplication.data.LoginResponseWrapper
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class APIResponse<T>(val context: Context) : Observer<LoginResponseWrapper<T>> {

    private var isShow: Boolean = true;

    constructor(context: Context, isShow: Boolean = false) : this(context) {
        this.isShow = isShow;
    }

    abstract fun success(data: T?)

    abstract fun failure(errorMsg: String?);

    override fun onSubscribe(d: Disposable) {
        if (isShow) {
        }
    }

    override fun onNext(t: LoginResponseWrapper<T>) {
        if (t.data == null) {
            failure("登录失败了")
        } else {
            success(t.data)
        }
    }

    override fun onError(e: Throwable) {
        failure(e.message)
    }

    override fun onComplete() {

    }
}