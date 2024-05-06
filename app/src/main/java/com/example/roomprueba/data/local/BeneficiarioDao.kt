package com.example.roomprueba.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomprueba.core.Constants.Companion.BENEFICIARIO_TABLE
import com.example.roomprueba.domain.model.Beneficiario
import com.example.roomprueba.domain.repository.Beneficiarios
import kotlinx.coroutines.flow.Flow

@Dao
interface BeneficiarioDao {

    @Query("SELECT * FROM $BENEFICIARIO_TABLE")
    fun getAllBeneficiarios(): Flow<Beneficiarios>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBeneficiario(beneficiario : Beneficiario)

    @Query("DELETE FROM $BENEFICIARIO_TABLE")
    fun deleteAllData()

}