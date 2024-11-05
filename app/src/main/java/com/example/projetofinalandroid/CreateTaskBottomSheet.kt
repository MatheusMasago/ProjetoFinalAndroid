package com.example.projetofinalandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText

class CreateTaskBottomSheet: BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.create_tasks_bottom_sheet, container, false)
        val btnAddTask = view.findViewById<Button>(R.id.btn_add_task)
        val edtNewTask = view.findViewById<TextInputEditText>(R.id.edt_new_task)


        return view

    }
}