package com.example.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class StudentDataBase : RoomDatabase() {
    abstract fun getStudentDao(): StudentDao


    companion object {
        private var INSTANCE: StudentDataBase? = null;
        fun getDatabse(context: Context): StudentDataBase? {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(
                        context,
                        StudentDataBase::class.java,
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