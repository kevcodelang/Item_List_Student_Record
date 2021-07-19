package com.example.item_studentrecord.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.item_studentrecord.api.RetrofitProvider
import com.example.item_studentrecord.models.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val itemsLiveData = MutableLiveData<List<Item>>()

    fun getItems() {
        RetrofitProvider.placeHolderAPI.getItems().enqueue(object : Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                response.body()?.let {
                    itemsLiveData.postValue(it)
                }
            }
            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
            }

        })

    }
}