package com.example.projetofinalandroid

import TaskListener
import adapter.TaskListAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetofinalandroid.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import data.TaskMock
import model.Tasks

class TasksListActivity : AppCompatActivity(){
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    private val auth by lazy{
        FirebaseAuth.getInstance()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.rvTasks.layoutManager = LinearLayoutManager(this)
        val mock = TaskMock()
        binding.rvTasks.adapter = TaskListAdapter(mock.listaTarefas,TaskListAdapter.OnClickListener{task ->
            Toast.makeText(this, task.nome, Toast.LENGTH_SHORT).show()
        })

        binding.btnBottonSheet.setOnClickListener {
            val bottomSheetFragment = CreateTaskBottomSheet()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }
        binding.btnShopList.setOnClickListener {
           val intent = Intent(this, ShopListActivity::class.java)
            startActivity(intent)
        }

    }
}
