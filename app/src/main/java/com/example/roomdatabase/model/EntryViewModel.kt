package com.example.roomdatabase.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.repositori.RepositoriSiswa


class EntryViewModel(private val repositorySiswa: RepositoriSiswa): ViewModel(){

    /**
     * Berisi status Siswa saat ini
     */
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa ): Boolean{
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa){
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    /* Fungsi untuk menyimpan data yang di -entry */
    suspend fun saveSiswa(){
        if (validasiInput()){
            repositorySiswa.insertSiswa(uiStateSiswa.detailSiswa.toSiswa())
        }
    }
}