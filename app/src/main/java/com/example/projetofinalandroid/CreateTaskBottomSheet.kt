package com.example.projetofinalandroid

import TaskListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText

class CreateTaskBottomSheet: BottomSheetDialogFragment() {
var taskListener: TaskListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.create_tasks_bottom_sheet, container, false)
        val btnAddTask = view.findViewById<Button>(R.id.btn_add_task)
        val edtNewTask = view.findViewById<TextInputEditText>(R.id.edt_new_task)

        btnAddTask.setOnClickListener {
            val task = edtNewTask.text.toString()
            if (task.isNotEmpty()) {
                taskListener?.onTaskAdded(task)
                dismiss()
            }
        }
        return view

    }
}