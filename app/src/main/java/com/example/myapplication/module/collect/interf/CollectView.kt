package com.example.myapplication.module.collect.interf

import com.example.myapplication.data.Student

interface CollectView {

    fun showResultSuccess(result: List<Student>);

    fun showResult(result: Boolean);
}