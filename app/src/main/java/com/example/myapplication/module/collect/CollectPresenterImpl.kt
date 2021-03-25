package com.example.myapplication.module.collect

import android.view.View
import com.example.myapplication.data.Student
import com.example.myapplication.module.collect.interf.CollectModel
import com.example.myapplication.module.collect.interf.CollectPresenter
import com.example.myapplication.module.collect.interf.CollectView

class CollectPresenterImpl(var view: CollectView?) : CollectPresenter,
    CollectPresenter.OnCollectResponseListener,
    CollectPresenter.OnCollectListener {

    private val module: CollectModel = CollectModelImpl();


    override fun requestInsert(vararg students: Student) {
        module.requestInsert(this, *students);
//        module.requestInsert(object :CollectPresenter.OnCollectListener{
//            override fun showIUD(iudResult: Boolean) {
//            }
//        }, *students);
    }

    override fun requestUpdate(vararg students: Student) {
        module.requestUpdate(this, *students);
    }

    override fun requestDeleteAll() {
        module.requestDeleteAll(this)
    }

    override fun requestQueryAll() {
        module.requestQueryAll(this)
    }

    override fun unAttachView() {
        view = null;
    }

    override fun showResultSuccess(result: List<Student>?) {
        TODO("Not yet implemented")
    }

    override fun showIUD(iudResult: Boolean) {
        TODO("Not yet implemented")
    }


}
