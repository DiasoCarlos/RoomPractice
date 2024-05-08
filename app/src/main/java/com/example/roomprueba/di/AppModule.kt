package com.example.roomprueba.di

import android.content.Context
import androidx.room.Room
import com.example.roomprueba.data.local.BeneficiarioDao
import com.example.roomprueba.data.local.BeneficiarioDatabase
import com.example.roomprueba.data.repository.BeneficiarioRepositoryImpl
import com.example.roomprueba.core.Constants.Companion.BENEFICIARIO_TABLE
import com.example.roomprueba.core.Constants.Companion.USER_TABLE
import com.example.roomprueba.data.local.UserDao
import com.example.roomprueba.data.local.UserDatabase
import com.example.roomprueba.data.repository.UserRepoImpl
import com.example.roomprueba.domain.repository.BeneficiarioRepository
import com.example.roomprueba.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //DATABASE USERS

    @Provides
    @Singleton
    fun provideUserDatabase(
        @ApplicationContext context: Context
    ) : UserDatabase{

        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            USER_TABLE
        ).build()

    }

    @Provides
    @Singleton
    fun provideUserDao(
        userDatabase: UserDatabase
    ) : UserDao {

        return userDatabase.UserDao()

    }

    @Provides
    @Singleton
    fun provideUserRepo(
        userDao: UserDao
    ) : UserRepository{

        return UserRepoImpl(
            userDao = userDao
        )

    }

    //DATABASE BENEFICIARIOS
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

        return beneficiarioDatabase.BeneticiarioDao()

    }

    @Provides
    @Singleton
    fun provideBeneficiarioRepository(beneficiarioDao: BeneficiarioDao) : BeneficiarioRepository{

        return BeneficiarioRepositoryImpl(
            beneficiarioDao = beneficiarioDao
        )

    }

}