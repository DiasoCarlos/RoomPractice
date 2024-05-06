package com.example.roomprueba.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.roomprueba.core.Constants.Companion.BENEFICIARIO_TABLE

@Entity(tableName = BENEFICIARIO_TABLE)
data class Beneficiario (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nombre : String,
    val apellido : String,
    val telefono : String,
    val calle : String,
    val numero : String,
    val codigoPostal : String,
    val colonia : String,
    val estado : String,
    val pais : String,
)