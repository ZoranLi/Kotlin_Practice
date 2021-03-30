package com.example.myapplication.data_module.loacl

import com.example.myapplication.data.Student

interface IDatabaseRequest {

    fun insertStudents(vararg students: Student);

    fun updateStudents(vararg students: Student);

    fun deleteStudents(vararg students: Student);

    fun deleteAllStudent();

    fun queryAllStudent():List<Student>?;

}