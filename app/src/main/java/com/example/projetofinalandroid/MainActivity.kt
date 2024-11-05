package com.example.projetofinalandroid

import UserDatabase.UserDao
import UserDatabase.UserDataBase
import UserDatabase.UserEntity
import UserDatabase.UserUiData
import android.content.Intent
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
            UserDataBase::class.java, "UserDataBase"
        ).build()
    }
    private val userDao: UserDao by lazy {
        db.getUserDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //insertUser()

        binding.btnLogin.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
        }

        binding.btnSignIn.setOnClickListener {
            val intent = Intent(this, CreaterAccountActivity::class.java)
            startActivity(intent)
        }
    }
    /*private fun deleteUser(){
        val usersEntity =
        userDao.delete()
    }*/
}