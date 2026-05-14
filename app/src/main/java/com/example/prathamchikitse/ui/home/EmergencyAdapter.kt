package com.example.prathamchikitse.ui.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prathamchikitse.data.model.EmergencyGuide
import com.example.prathamchikitse.databinding.ItemEmergencyTileBinding

class EmergencyAdapter(
    private val onItemClick: (EmergencyGuide) -> Unit
) : RecyclerView.Adapter<EmergencyAdapter.EmergencyViewHolder>() {

    private val items = mutableListOf<EmergencyGuide>()

    fun submitList(newItems: List<EmergencyGuide>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmergencyViewHolder {
        val binding = ItemEmergencyTileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmergencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmergencyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class EmergencyViewHolder(
        private val binding: ItemEmergencyTileBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EmergencyGuide) {
            binding.titleText.text = item.title
            binding.root.setCardBackgroundColor(Color.parseColor(item.tileColorHex))
            binding.root.setOnClickListener { onItemClick(item) }
        }
    }
}
