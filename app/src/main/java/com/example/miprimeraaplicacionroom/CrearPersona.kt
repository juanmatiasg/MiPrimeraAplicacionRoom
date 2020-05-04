package com.example.miprimeraaplicacionroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_crear_persona.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity

import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread


class CrearPersona : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_persona)

        InsertarPersona.setOnClickListener {
            var nombre: String = editTextNombre.text.toString()
            var apellido: String = editTextApellido.text.toString()
            var edad: String = editTextEdad.text.toString()
            var dni: String = editTextDni.text.toString()

            var estudiantes =
                Estudiantes(id = 0, nombre = nombre, apellido = apellido, edad = edad, dni = dni)

            doAsync {
                val id = MisNotasApp.database.taskDao().insertarTask(estudiantes)

                uiThread {
                    if (id > 0) {
                        startActivity<MainActivity>()
                    } else {
                        toast("No inserto estudiantes")
                    }
                }

            }
        }
    }
}




