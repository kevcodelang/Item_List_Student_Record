package com.example.item_studentrecord.api

import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitProvider {
    private  var retrofit=Retrofit.Builder()
        .baseUrl("https://ict-yep-backend.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val placeHolderAPI= retrofit.create(PlaceHolderAPI::class.java)
}