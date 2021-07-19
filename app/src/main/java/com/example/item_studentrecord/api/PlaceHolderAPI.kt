package com.example.item_studentrecord.api

import com.example.item_studentrecord.models.Item
import retrofit2.Call
import retrofit2.http.GET

interface PlaceHolderAPI {
    @GET("items")
    fun getItems(): Call<List<Item>>
}