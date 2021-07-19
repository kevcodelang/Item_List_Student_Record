package com.example.item_studentrecord.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentrecord.databinding.ItemListBinding
import com.example.item_studentrecord.models.Item

class ItemsAdapter(var items: List<Item>) :
    RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {

    class ItemsViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: Item) {
            binding.apply {
                itemID.text = item.id.toString()
                name.text = item.name
                price.text = item.price.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val binding=ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return ItemsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}


