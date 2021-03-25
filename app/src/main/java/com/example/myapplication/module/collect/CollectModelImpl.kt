package com.example.myapplication.module.collect

import com.example.myapplication.data.Student
import com.example.myapplication.module.collect.interf.CollectModel
import com.example.myapplication.module.collect.interf.CollectPresenter

/**
 *
 */
class CollectModelImpl : CollectModel {
    override fun requestInsert(
        listener: CollectPresenter.OnCollectListener,
        vararg students: Student
    ) {
        TODO("Not yet implemented")
    }

    override fun requestUpdate(
        listener: CollectPresenter.OnCollectListener,
        vararg students: Student
    ) {
        TODO("Not yet implemented")
    }

    override fun requestDelete(
        listener: CollectPresenter.OnCollectListener,
        vararg students: Student
    ) {
        TODO("Not yet implemented")
    }

    override fun requestDeleteAll(listener: CollectPresenter.OnCollectListener) {
        TODO("Not yet implemented")
    }

    override fun requestQueryAll(listener: CollectPresenter.OnCollectListener) {
        TODO("Not yet implemented")
    }

}

