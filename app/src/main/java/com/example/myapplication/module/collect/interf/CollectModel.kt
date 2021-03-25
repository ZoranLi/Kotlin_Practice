package com.example.myapplication.module.collect.interf

import com.example.myapplication.data.Student

interface CollectModel {

    //去请求
    fun requestInsert(listener: CollectPresenter.OnCollectListener, vararg students: Student);

    fun requestUpdate(listener: CollectPresenter.OnCollectListener, vararg students: Student);

    fun requestDelete(listener: CollectPresenter.OnCollectListener, vararg students: Student);//删除

    fun requestDeleteAll(listener: CollectPresenter.OnCollectListener);//删除全部

    fun requestQueryAll(listener: CollectPresenter.OnCollectListener);//查询全部

}