package com.example.roomprueba.domain.repository

import com.example.roomprueba.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun isUserAndPasswordValid (username: String, password: String) : Flow<User>

    fun addUser(user: User)

}