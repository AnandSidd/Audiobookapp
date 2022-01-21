package com.siddharth.audiobook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.siddharth.audiobook.databinding.ItemBinding
import com.siddharth.audiobook.databinding.ItemlistBinding

class ArtistAdapter : RecyclerView.Adapter<ArtistViewHolder>() {

    private var artists = emptyList<Results>()

    fun submitList(todoList: List<Results>) {
        artists = todoList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ArtistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemlistBinding.inflate(inflater, parent, false)
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.binding.songname.text = artists[position].trackName
        Glide.with(holder.binding.root).load(artists[position].artworkUrl60).into(holder.binding.songimage)
        holder.binding.desc.text = artists[position].description

    }

    override fun getItemCount() = artists.size

}

class ArtistViewHolder(val binding: ItemlistBinding) : RecyclerView.ViewHolder(binding.root)