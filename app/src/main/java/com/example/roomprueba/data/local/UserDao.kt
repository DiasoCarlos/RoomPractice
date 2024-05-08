package com.example.roomprueba.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomprueba.core.Constants.Companion.USER_TABLE
import com.example.roomprueba.domain.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM $USER_TABLE WHERE username = :username AND password = :password")
    fun isUserAndPasswordValid(username : String, password : String) : Flow<User>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun addUser(user: User)

}