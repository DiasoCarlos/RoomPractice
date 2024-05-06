package com.example.roomprueba.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomprueba.domain.model.Beneficiario
import com.example.roomprueba.domain.repository.BeneficiarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: BeneficiarioRepository
) : ViewModel(){

    val beneficiarios = repository.getBeneficiariosFromRoom()

    fun addBeneficiario(){

        val newBeneficiarioToAdd = Beneficiario(
            nombre = "PEPE",
            apellido = "Lepu",
            telefono = "2233322323",
            calle = "Tamaulipas",
            numero = "150",
            codigoPostal = "11800",
            colonia = "Condesa",
            estado = "CDMX",
            pais = "Mexico"
        )

        viewModelScope.launch(Dispatchers.IO) {
            repository.addBeneficiarioToRoom(newBeneficiarioToAdd)
        }

    }

    fun deleteAll(){

        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllData()
        }

    }

}