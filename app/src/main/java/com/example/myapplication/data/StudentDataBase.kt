package com.example.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * 数据库 版本号
 */
@Database(entities = [Student::class], version = 1)
abstract class StudentDataBase : RoomDatabase() {//需要继承

    abstract fun getStudentDao(): StudentDao//数据库的增删改查

    companion object {
        //派生
        private var INSTANCE: StudentDataBase? = null;

        //给application中调用
        fun init(context: Context): StudentDataBase? {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(
                        context,
                        StudentDataBase::class.java,//room底层是Java
                        "student_database.db"
                    )
                        .allowMainThreadQueries()//允许在主线程中查询
                        .build();
            }
            return INSTANCE;
        }

        fun getDataBase(): StudentDataBase? = INSTANCE;

    }
}