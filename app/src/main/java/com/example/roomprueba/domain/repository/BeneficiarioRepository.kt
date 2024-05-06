package com.example.roomprueba.domain.repository

import com.example.roomprueba.domain.model.Beneficiario
import kotlinx.coroutines.flow.Flow

typealias Beneficiarios = List<Beneficiario>
interface BeneficiarioRepository {

    fun getBeneficiariosFromRoom() : Flow<Beneficiarios>

    fun addBeneficiarioToRoom( beneficiario: Beneficiario)

    fun deleteAllData()

}