package com.example.roomdatabase.navigasi

interface DestinasiNavigasi {
    /**
     *  Nama unik untuk menentukan jalur untuk composable
     */
    val route: String

    /**
     *  String resource id yang berisi judul akan ditampilkan di layar halaman.
     */
    val titleRes: Int
}