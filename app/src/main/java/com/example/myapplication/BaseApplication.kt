package com.example.myapplication

import android.app.Application
import com.example.myapplication.data.StudentDataBase

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        StudentDataBase.init(this);
    }
}