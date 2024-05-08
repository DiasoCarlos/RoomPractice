package com.example.roomprueba.data.repository

import com.example.roomprueba.data.local.UserDao
import com.example.roomprueba.domain.model.User
import com.example.roomprueba.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository{

    override fun isUserAndPasswordValid(username: String, password: String) = userDao.isUserAndPasswordValid(username, password)

    override fun addUser(user: User) = userDao.addUser(user)

}