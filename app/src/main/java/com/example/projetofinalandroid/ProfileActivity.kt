package com.example.projetofinalandroid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetofinalandroid.databinding.ActivityProfileBinding
import com.example.projetofinalandroid.databinding.ActivityRecoverPasswordActiviyBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ProfileActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityProfileBinding.inflate(layoutInflater)
    }
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }
    private val db by lazy {
        FirebaseFirestore.getInstance()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        loadData()

        binding.btnEditarPerfil.setOnClickListener {
        val uid = auth.currentUser?.uid
        val email = binding.edtEmail.text.toString()
        val nome = binding.edtNome.text.toString()

            val dados = mapOf(
            "nome" to nome,
            "email" to email
        )

        db.collection("utilizadores")
            .document(uid.toString())
            .update(dados)
            .addOnSuccessListener {
                Toast.makeText(this, "Dados atualizados com sucesso", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Erro ao atualizar dados", Toast.LENGTH_SHORT).show()
            }

        }
        binding.btnLogout.setOnClickListener {
            auth.signOut()
            finish()
        }
        binding.btnDeleteAccount.setOnClickListener {
            val uid = auth.currentUser?.uid
            db.collection("utilizadores")
                .document(uid.toString())
                .delete()
                .addOnSuccessListener {
                    auth.currentUser?.delete()
                    Toast.makeText(this, "Conta deletada com sucesso", Toast.LENGTH_SHORT).show()
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Erro ao deletar conta", Toast.LENGTH_SHORT).show()
                }
        }

    }
    private fun loadData(){
        val uid = auth.currentUser?.uid
        db.collection("utilizadores")
            .document(uid.toString())
            .get()
            .addOnSuccessListener {
            val email = it.data?.get("email")
            val nome = it.data?.get("nome")
                binding.edtEmail.setText(email.toString())
                binding.edtNome.setText(nome.toString())
            }
            .addOnFailureListener {  }
    }


}