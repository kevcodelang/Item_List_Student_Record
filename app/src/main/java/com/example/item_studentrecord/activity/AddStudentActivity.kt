package com.example.item_studentrecord.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.item_studentrecord.models.Student
import com.example.item_studentrecord.ui.MainViewModel
import com.example.studentrecord.databinding.ActivityAddStudentBinding

class StudentAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddStudentBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //instantiating viewModel
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.btnAdd.setOnClickListener {
            addStudent()
        }

    }

    private fun addStudent() {
        val name = binding.textInputName.editText?.text.toString()
        val seat = binding.textInputSeat.editText?.text.toString()
        val classNames = binding.textInputClass.editText?.text.toString()

        if (name.isNotEmpty() && seat.isNotEmpty() && classNames.isNotEmpty()) {
            //adding new student to server
            val newStudent = Student(name, seat, classNames)
            viewModel.addStudent(newStudent)
            Toast.makeText(this, "Successfully Added", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }
}