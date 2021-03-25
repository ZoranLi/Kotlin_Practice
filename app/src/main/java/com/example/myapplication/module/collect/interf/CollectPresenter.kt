package com.example.myapplication.module.collect.interf

import com.example.myapplication.data.Student

interface CollectPresenter : IbasePresenter {

    //去请求
    fun requestInsert(vararg students: Student);

    fun requestUpdate(vararg students: Student);

    fun requestDeleteAll();//删除全部

    fun requestQueryAll();//查询全部


    interface OnCollectResponseListener {
        fun showResultSuccess(result: List<Student>?);
    }

    interface OnCollectListener {
        fun showIUD(iudResult: Boolean);
    }

}