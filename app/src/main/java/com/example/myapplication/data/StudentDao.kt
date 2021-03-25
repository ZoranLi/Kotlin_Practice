package com.example.myapplication.data

import androidx.room.*

@Dao
interface StudentDao {
    @Insert
    fun insertStudents(vararg students: Student) //可变参数

    @Update
    fun updateStudents(vararg students: Student) //可变参数

    @Query("DELETE FROM student")
    fun queryStudents(vararg students: Student) //可变参数

    //查询全部
    @Query("SELECT * FROM student ORDER BY ID DESC")
    fun queryAllStudents(): List<Student>;
}