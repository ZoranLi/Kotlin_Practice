package com.example.myapplication.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseFragment<P> : Fragment() where P : IBasePresenter {

    lateinit var p: P;


    private lateinit var mActivity: AppCompatActivity;


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        p = getPresenter();
    }

    abstract fun getPresenter(): P;

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createOk();
    }

    abstract fun createOk()

    override fun onDestroy() {
        super.onDestroy()
        recycle();
    }

    abstract fun recycle()

    fun hideActionBar(): Unit {
        var actionBar: ActionBar? = mActivity?.supportActionBar;
        actionBar?.hide();
    }

    fun showActionBar(): Unit {
        mActivity?.supportActionBar?.show();
    }
}