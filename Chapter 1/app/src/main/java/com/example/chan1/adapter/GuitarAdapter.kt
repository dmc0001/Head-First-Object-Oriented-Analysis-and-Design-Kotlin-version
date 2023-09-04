package com.example.chan1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chan1.data.Guitar
import com.example.chan1.databinding.ItemGuitarBinding


class GuitarAdapter : RecyclerView.Adapter<GuitarAdapter.GuitarViewHolder>() {

    inner class GuitarViewHolder(private val binding: ItemGuitarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(guitar: Guitar) {
            binding.apply {
                tvSerialNumber.text = "Serial Number: ${guitar.serialNumber}"
                tvModel.text = "Model: ${guitar.guitarSpec.model}"
                tvPrice.text = "Price: $${guitar.price}"
                tvBuilder.text = "Builder: ${guitar.guitarSpec.builder}"
                tvType.text = "Type: ${guitar.guitarSpec.type}"
                tvBackWood.text = "Back Wood: ${guitar.guitarSpec.backWood}"
                tvTopWood.text = "Top Wood: ${guitar.guitarSpec.topWood}"
            }
        }

    }

    private val diffCallback = object : DiffUtil.ItemCallback<Guitar>() {
        override fun areItemsTheSame(oldItem: Guitar, newItem: Guitar): Boolean {
            return oldItem.serialNumber == newItem.serialNumber
        }

        override fun areContentsTheSame(oldItem: Guitar, newItem: Guitar): Boolean {
            return newItem == oldItem
        }

    }
    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuitarViewHolder {

        return GuitarViewHolder(
            binding = ItemGuitarBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: GuitarViewHolder, position: Int) {
        val guitar = differ.currentList[position]
        holder.bind(guitar)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}