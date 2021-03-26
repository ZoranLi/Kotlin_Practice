package com.example.myapplication.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.module.login.inter.LoginPresenter

abstract class BaseActivity<P> : AppCompatActivity() where P : IBasePresenter {

    lateinit var presenter: P;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = createP();
    }

    //    给子类完成
    abstract fun createP(): P;
    abstract fun recycle();

//
    override fun onDestroy() {
        super.onDestroy()
        recycle();

    }

}