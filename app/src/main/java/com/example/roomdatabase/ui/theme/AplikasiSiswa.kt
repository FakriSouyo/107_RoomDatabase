package com.example.roomdatabase.ui.theme

import android.app.Application
import com.example.roomdatabase.repositori.ContainerApp
import com.example.roomdatabase.repositori.ContainerDataApp


class AplikasiSiswa : Application() {
    /**
     * AppContainer instance digunakan oleh kelas-kelas lainnya untuk mendapatkan dependensi
     */
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}