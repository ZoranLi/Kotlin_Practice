package com.example.myapplication.module.collect

import com.example.myapplication.data.Student
import com.example.myapplication.data_module.loacl.LocalRoomRequestManager
import com.example.myapplication.module.collect.interf.CollectModel
import com.example.myapplication.module.collect.interf.CollectPresenter

/**
 *操作数据库
 */
class CollectModelImpl : CollectModel {

    override fun requestInsert(
        listener: CollectPresenter.OnCollectListener,
        vararg students: Student
    ) {
        LocalRoomRequestManager.getInstance().studentDao?.insertStudents(*students);
        listener.showIUD(true)
    }

    override fun requestUpdate(
        listener: CollectPresenter.OnCollectListener,
        vararg students: Student
    ) {
        LocalRoomRequestManager.getInstance().studentDao?.updateStudents(*students);
        listener.showIUD(true)
    }

    override fun requestDelete(
        listener: CollectPresenter.OnCollectListener,
        vararg students: Student
    ) {
        LocalRoomRequestManager.getInstance().studentDao?.deleteStudents(*students);
        listener.showIUD(true)
    }

    override fun requestDeleteAll(listener: CollectPresenter.OnCollectListener) {
        LocalRoomRequestManager.getInstance().studentDao?.deleteAllStudents();
        listener.showIUD(true)
    }


    override fun requestQueryAll(listener: CollectPresenter.OnCollectResponseListener) {
        val result =  LocalRoomRequestManager.getInstance().studentDao?.queryAllStudents();
//        listener.showResultSuccess(result)
        listener.showResultSuccess(result);
    }

}

