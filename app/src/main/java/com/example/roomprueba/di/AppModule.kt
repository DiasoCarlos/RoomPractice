package com.example.roomprueba.di

import android.content.Context
import androidx.room.Room
import com.example.roomprueba.data.local.BeneficiarioDao
import com.example.roomprueba.data.local.BeneficiarioDatabase
import com.example.roomprueba.data.repository.BeneficiarioRepositoryImpl
import com.example.roomprueba.core.Constants.Companion.BENEFICIARIO_TABLE
import com.example.roomprueba.domain.repository.BeneficiarioRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext : Context) : BeneficiarioDatabase {
        return Room.databaseBuilder(
            appContext,
            BeneficiarioDatabase::class.java,
            BENEFICIARIO_TABLE
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(beneficiarioDatabase : BeneficiarioDatabase) : BeneficiarioDao {

        return beneficiarioDatabase.beneticiarioDao()

    }

    @Provides
    @Singleton
    fun provideBeneficiarioRepository(beneficiarioDao: BeneficiarioDao) : BeneficiarioRepository{

        return BeneficiarioRepositoryImpl(
            beneficiarioDao = beneficiarioDao
        )

    }

}