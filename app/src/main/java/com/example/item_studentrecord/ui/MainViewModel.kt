package com.example.item_studentrecord.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.item_studentrecord.api.RetrofitProvider
import com.example.item_studentrecord.models.Item
import com.example.item_studentrecord.models.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    val itemsLiveData = MutableLiveData<List<Item>>()
    val studentsLiveData = MutableLiveData<List<Student>>()

    fun getItems() {
        CoroutineScope(Dispatchers.IO).launch {
            itemsLiveData.postValue(RetrofitProvider.placeHolderAPI.getItems())
        }
    }

    fun addStudent(newStudent: Student) {
        CoroutineScope(Dispatchers.IO).launch {
            studentsLiveData.postValue(RetrofitProvider.placeHolderAPI.addStudents(newStudent))
        }
    }
}



