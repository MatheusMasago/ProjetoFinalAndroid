package com.example.projetofinalandroid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetofinalandroid.databinding.ActivityLoginBinding
import com.example.projetofinalandroid.databinding.ActivityRecoverPasswordActiviyBinding
import com.google.firebase.auth.FirebaseAuth

class RecoverPasswordActiviy : AppCompatActivity() {
    private val binding by lazy {
        ActivityRecoverPasswordActiviyBinding.inflate(layoutInflater)
    }
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.btnRecoverPassword.setOnClickListener {

            val email = binding.edtEmailToRecoverPassword.text.toString()

            auth.sendPasswordResetEmail(email)
                .addOnSuccessListener {
                    Toast.makeText(this, "Email enviado com sucesso", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Erro ao enviar email", Toast.LENGTH_SHORT).show()

                }
        }
    }
}