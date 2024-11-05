package com.example.projetofinalandroid

import Adapter.TaskListAdapter
import Data.TasksMock
import Model.Task
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetofinalandroid.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvTasks.layoutManager = LinearLayoutManager(this)
        val mock = TasksMock()
        binding.rvTasks.adapter = TaskListAdapter(mock.taskList, TaskListAdapter.OnClickListener{ task ->
            Toast.makeText(this, task.tarefa, Toast.LENGTH_SHORT).show()

        })

        binding.btnShopList.setOnClickListener {
            val intent = Intent(this, ShopListActivity::class.java)
            startActivity(intent)
        }
        val task = ArrayList<String>()
    }
}
