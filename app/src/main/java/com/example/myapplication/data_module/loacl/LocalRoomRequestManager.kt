package com.example.myapplication.data_module.loacl

import com.example.myapplication.data.Student
import com.example.myapplication.data.StudentDao
import com.example.myapplication.data.StudentDataBase

class LocalRoomRequestManager : ILocalRequest, IDatabaseRequest {

    var studentDao: StudentDao? = null

    // Java构造代码块  dao
    init {
        val studentDatabase: StudentDataBase? = StudentDataBase.getDataBase()
        studentDao = studentDatabase?.getStudentDao()
    }

    // 单例模式而已
    companion object {
        var INSTANCE: LocalRoomRequestManager? = null
        fun getInstance(): LocalRoomRequestManager {
            if (INSTANCE == null) {
                synchronized(LocalRoomRequestManager::class) {
                    if (INSTANCE == null) {
                        INSTANCE = LocalRoomRequestManager()
                    }
                }
            }
            return INSTANCE!!
        }
    }


    override fun insertStudents(vararg students: Student) {
        studentDao?.insertStudents(*students);
    }

    override fun updateStudents(vararg students: Student) {
        studentDao?.updateStudents(*students);
    }

    override fun deleteStudents(vararg students: Student) {
        studentDao?.deleteStudents(*students);
    }

    override fun deleteAllStudent() {
        studentDao?.deleteAllStudents()
    }

    override fun queryAllStudent(): List<Student>? {
        return studentDao?.queryAllStudents()
    }
}