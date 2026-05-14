package com.example.prathamchikitse.ui.hospital

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prathamchikitse.data.model.Hospital
import com.example.prathamchikitse.databinding.ItemHospitalBinding

class HospitalAdapter : RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {

    private val items = mutableListOf<Hospital>()

    fun submitList(newItems: List<Hospital>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val binding = ItemHospitalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HospitalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class HospitalViewHolder(
        private val binding: ItemHospitalBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Hospital) {
            binding.nameText.text = item.name
            binding.addressText.text = item.address
            binding.phoneText.text = item.phone
        }
    }
}
