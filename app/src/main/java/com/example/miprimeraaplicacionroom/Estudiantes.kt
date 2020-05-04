package com.example.miprimeraaplicacionroom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_estudiantes")
data class Estudiantes(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var nombre: String,
    var apellido: String,
    var edad: String,
    var dni: String
) {
    override fun toString(): String {
        return "Nombre='$nombre'\nApellido='$apellido'\nEdad='$edad'\nDNI='$dni'"
    }
}

