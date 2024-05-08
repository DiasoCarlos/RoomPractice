package com.example.roomprueba.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomprueba.domain.model.Beneficiario

@Database(entities = [Beneficiario::class], version = 1, exportSchema = false)
abstract class BeneficiarioDatabase : RoomDatabase(){

    abstract fun BeneticiarioDao() : BeneficiarioDao

}