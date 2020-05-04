package com.example.miprimeraaplicacionroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_crear_persona.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    lateinit var listPersonas: MutableList<Estudiantes> /*llenar en la base de datos*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnCrear.setOnClickListener {
            var intent = Intent(this, CrearPersona::class.java)
            startActivity(intent)
        }

        doAsync {
            var cantidad: Int = MisNotasApp.database.taskDao().count()
            uiThread {
                toast("Hay ${cantidad} registros ")
            }
        }

        btnListar.setOnClickListener {
            var intent = Intent(this, ListarPersonas::class.java)
            startActivity(intent)
        }

        btnBorrar.setOnClickListener {
            doAsync {
                listPersonas = MisNotasApp.database.taskDao().obtenerTodo() /*Asignar a Dao*/
                MisNotasApp.database.taskDao()
                    .eliminarTask(listPersonas) /*Borrar en la base de datos*/

                var cantidad: Int = MisNotasApp.database.taskDao().count()
                uiThread {
                    toast("Hay $cantidad registros")
                }
            }
        }


    }
}




