package com.example.item_studentrecord.models


import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("class")
    val classX: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("seat")
    val seat: String
)