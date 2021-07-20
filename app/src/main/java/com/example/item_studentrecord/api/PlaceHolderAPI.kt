package com.example.item_studentrecord.api

import com.example.item_studentrecord.models.Item
import com.example.item_studentrecord.models.Student
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PlaceHolderAPI {
    @GET("items")
    fun getItems(): List<Item>
    @POST("students")
    suspend fun addStudents(@Body newStudent: Student): List<Student>
}