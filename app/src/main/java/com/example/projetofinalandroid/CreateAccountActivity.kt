package com.example.projetofinalandroid


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetofinalandroid.databinding.ActivityCreaterAccountBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class CreateAccountActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityCreaterAccountBinding.inflate(layoutInflater)
    }
    private val auth by lazy{
        FirebaseAuth.getInstance()
    }
    private val db by lazy{
        FirebaseFirestore.getInstance()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCreateAccount.setOnClickListener {
            val email = binding.edtNewPassword.text.toString()
            val username = binding.edtNewUsername.text.toString()

            auth.createUserWithEmailAndPassword(username, email)
                .addOnSuccessListener {
                    Toast.makeText(this,"Conta criada com sucesso", Toast.LENGTH_SHORT).show()
                    auth.currentUser?.sendEmailVerification()
                    gravarUtilizador(email)
                    finish()
                    val intent = Intent(this, TasksListActivity::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener {
                  Toast.makeText(this,"Erro ao criar conta", Toast.LENGTH_SHORT).show()
                }
        }
        binding.tvAccountExists.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun gravarUtilizador(email: String) {
        val uid = auth.currentUser?.uid
        val dados = mapOf(
            "nome" to "",
            "email" to email
        )
        db.collection("utilizadores")
            .document(uid.toString())
            .set(dados)
            .addOnSuccessListener {

            }.addOnFailureListener {

            }

        }
    }