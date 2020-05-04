package com.example.miprimeraaplicacionroom

import android.app.Application
import androidx.room.Room

class MisNotasApp : Application() {

    companion object {
        lateinit var database: Database
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, Database::class.java, "dbDos").build()
    }


}