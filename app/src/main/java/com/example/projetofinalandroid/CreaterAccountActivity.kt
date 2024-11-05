package com.example.projetofinalandroid

import UserDatabase.UserDao
import UserDatabase.UserDataBase
import UserDatabase.UserEntity
import UserDatabase.UserUiData
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.projetofinalandroid.databinding.ActivityCreaterAccountBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreaterAccountActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityCreaterAccountBinding.inflate(layoutInflater)
    }
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            UserDataBase::class.java, "UserDataBase"
        ).build()
    }
    private val userDao: UserDao by lazy {
        db.getUserDao()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCreateAccount.setOnClickListener {
            val password = binding.edtNewPassword.text.toString()
            val username = binding.edtNewUsername.text.toString()
            insertUser(username,password)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.tvAccountExists.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun insertUser(username: String, password: String){
        val usersEntity = userList.map {
            UserEntity(
                id = 0,
                userName = username,
                userPassword = password,
            )
        }
        GlobalScope.launch(Dispatchers.IO) {
            userDao.insert(usersEntity)
        }
    }
    val userList = listOf(
        UserUiData(
            id = 0,
            name = "",
            password = ""
        )
    )
}