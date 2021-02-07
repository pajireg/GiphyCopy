package com.sumin.giphycopy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sumin.giphycopy.api.Data
import com.sumin.giphycopy.databinding.ListTrendingBinding

class TrendingAdapter : ListAdapter<Data, TrendingAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private val binding: ListTrendingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.data = data
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListTrendingBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataProperty = getItem(position)
        holder.bind(dataProperty)
    }
}