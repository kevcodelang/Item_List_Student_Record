package com.example.item_studentrecord.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.studentrecord.databinding.ActivityMainBinding
import com.example.item_studentrecord.ui.ItemsAdapter
import com.example.item_studentrecord.ui.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var itemsAdapter: ItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemsAdapter = ItemsAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, StudentAddActivity::class.java)
            startActivity(intent)
        }

        binding.studRV.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 1)
            adapter = itemsAdapter
        }
        viewModel.run {
            getItems()
            itemsLiveData.observe(this@MainActivity, { items ->
                itemsAdapter.items = items
                itemsAdapter.notifyDataSetChanged()

            })
        }
    }
}