package com.example.miprimeraaplicacionroom

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Estudiantes::class), version = 1)
abstract class Database : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}