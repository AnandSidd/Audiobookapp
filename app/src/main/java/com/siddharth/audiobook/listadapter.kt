package com.siddharth.audiobook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.siddharth.audiobook.databinding.ItemBinding

class listadapter : RecyclerView.Adapter<AudioViewHolder>() {

    private var results = emptyList<Results>()

    fun submitList(todoList: List<Results>) {
        results = todoList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):AudioViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return AudioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        holder.binding.songname.text = results[position].trackName
        Glide.with(holder.binding.root).load(results[position].artworkUrl60).into(holder.binding.songimage)
        holder.binding.desc.text = results[position].description
        holder.binding.artistname.text = results[position].artistName

    }

    override fun getItemCount() = results.size

}

class AudioViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)