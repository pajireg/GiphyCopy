package com.sumin.giphycopy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sumin.giphycopy.R
import com.sumin.giphycopy.data.DataModel
import com.sumin.giphycopy.databinding.ListTrendingBinding

class TrendingAdapter(
        private val onFavoriteClickListener: FavoriteClickListener
    ) : ListAdapter<DataModel, TrendingAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private val binding: ListTrendingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataModel) {
            binding.data = data
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<DataModel>() {
        override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
            return oldItem.id == newItem.id
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListTrendingBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)

        val favoriteBtn = holder.itemView.findViewById<ImageView>(R.id.favoriteBtn)
        favoriteBtn.setOnClickListener {
            onFavoriteClickListener.onClick(data)
            when (data.isFavorite) {
                // isFavorite 이 true 면(favoriteEntity 에 데이터가 있으면) 버튼 토글
                true -> favoriteBtn.setImageResource(R.drawable.ic_outline_thumb_up_48)
                // isFavorite 이 true 가 아니면 버튼 토글
                else -> favoriteBtn.setImageResource(R.drawable.ic_baseline_thumb_up_48)
            }
        }
        holder.bind(data)
    }

    // favorite 버튼 클릭
    class FavoriteClickListener(val clickListener: (data: DataModel) -> Unit) {
        fun onClick(data: DataModel) = clickListener(data)
    }
}