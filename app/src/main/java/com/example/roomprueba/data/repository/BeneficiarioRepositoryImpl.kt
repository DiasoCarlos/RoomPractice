package com.example.roomprueba.data.repository

import com.example.roomprueba.data.local.BeneficiarioDao
import com.example.roomprueba.domain.model.Beneficiario
import com.example.roomprueba.domain.repository.BeneficiarioRepository
import javax.inject.Inject

class BeneficiarioRepositoryImpl @Inject constructor (
    private val beneficiarioDao: BeneficiarioDao
) : BeneficiarioRepository {

    override fun getBeneficiariosFromRoom() = beneficiarioDao.getAllBeneficiarios()

    override fun addBeneficiarioToRoom(beneficiario: Beneficiario) = beneficiarioDao.insertBeneficiario(beneficiario)

    override fun deleteAllData() = beneficiarioDao.deleteAllData()

}
