package com.example.myapplication.module.collect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.data.Student
import com.example.myapplication.module.collect.interf.CollectPresenter
import com.example.myapplication.module.collect.interf.CollectView

/**
 * 收藏中心
 * view 的实现层
 */
class CollectFragment : BaseFragment<CollectPresenter>(), CollectView {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(activity, "收藏", Toast.LENGTH_SHORT).show()
        val root: View? = inflater.inflate(R.layout.fragment_collect, container, false)// = null;
        return root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    //类似构造代码块
    init {
        setHasOptionsMenu(true)
    }

    override fun getPresenter(): CollectPresenter = CollectPresenterImpl(this);

    override fun createOk() {
        p.requestQueryAll();
    }

    override fun recycle() {
        p.unAttachView();
    }

    override fun showResultSuccess(result: List<Student>) {

    }

    override fun showResult(result: Boolean) {
        
    }
}