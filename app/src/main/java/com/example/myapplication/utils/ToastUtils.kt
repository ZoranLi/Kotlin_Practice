package com.example.myapplication.utils

import android.content.Context
import android.widget.Toast

class ToastUtils {

    private var toast: Toast? = null;

    object Holder {
        val INSTANCE = ToastUtils();
    }

    companion object {
        val instance = Holder.INSTANCE;
    }

    fun showToast(context: Context, message: String) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            toast?.show();
        }
    }

}