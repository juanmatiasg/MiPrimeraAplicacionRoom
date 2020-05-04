package com.example.miprimeraaplicacionroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_crear_persona.*
import kotlinx.android.synthetic.main.activity_listar_personas.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ListarPersonas : AppCompatActivity() {

    lateinit var listPersonas: MutableList<Estudiantes> /*Llenar la informacion en la base de datos*/

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_personas)


        doAsync {
            /*Obtener toda la lista por Dao */
            listPersonas = MisNotasApp.database.taskDao().obtenerTodo()


            var adapterPersona =
                ArrayAdapter(ctx, android.R.layout.simple_list_item_1, listPersonas)

            uiThread {
                listView.adapter = adapterPersona
            }
        }
    }
}
