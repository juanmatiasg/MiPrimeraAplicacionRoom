package com.example.miprimeraaplicacionroom

import androidx.room.*

@Dao
interface TaskDao {

    @Query("Select * from table_estudiantes")
    fun obtenerTodo(): MutableList<Estudiantes>


    @Query("Select COUNT(*) From table_estudiantes")
    fun count(): Int

    @Insert
    fun insertarTask(estudiantes: Estudiantes): Long

    @Delete
    fun eliminarTask(estudiantes: MutableList<Estudiantes>)


}