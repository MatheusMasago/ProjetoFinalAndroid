package com.example.projetofinalandroid

import UserDatabase.UserDao
import UserDatabase.UserDataBase
import UserDatabase.UserEntity
import UserDatabase.UserUiData
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.projetofinalandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            UserDataBase::class.java, "database-user"
        ).build()

    }
    private val userDao: UserDao by lazy {
        db.getUserDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertUser()

        val username = binding.edtUsername.text.toString()
        val password = binding.edtPassword.text.toString()

    }
    private fun insertUser(){
        val usersEntity = userList.map {
            UserEntity(
                id = 0,
                userName = it.name,
                userPassword = it.password,
            )
        }
        GlobalScope.launch(Dispatchers.IO) {
            userDao.insertAll(usersEntity)
        }

    }

    /*private fun deleteUser(){
        val usersEntity =
        userDao.delete()
    }*/
    val userList = listOf(
        UserUiData(
            id = 1,
            name = "user1",
            password = "pass1"
        )
    )
}