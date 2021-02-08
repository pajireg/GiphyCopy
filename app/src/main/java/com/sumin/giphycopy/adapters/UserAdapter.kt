package com.sumin.giphycopy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sumin.giphycopy.data.entity.FavoriteEntity
import com.sumin.giphycopy.databinding.ListFavoriteBinding

class UserAdapter(
    private val onClickListener: OnClickListener
) : ListAdapter<FavoriteEntity, UserAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private val binding: ListFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(favoriteEntity: FavoriteEntity) {
            binding.favorite = favoriteEntity
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<FavoriteEntity>() {
        override fun areItemsTheSame(oldItem: FavoriteEntity, newItem: FavoriteEntity): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: FavoriteEntity, newItem: FavoriteEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListFavoriteBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favoriteEntity = getItem(position)
        // gif 프리뷰 클릭
        holder.itemView.setOnClickListener {
            onClickListener.onClick(favoriteEntity)
        }
        holder.bind(favoriteEntity)
    }
    // gif 프리뷰 클릭 리스너
    class OnClickListener(val clickListener: (favoriteEntity: FavoriteEntity) -> Unit) {
        fun onClick(favoriteEntity: FavoriteEntity) = clickListener(favoriteEntity)
    }
}