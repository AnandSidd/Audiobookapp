package com.siddharth.audiobook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.siddharth.audiobook.databinding.ItemBinding

class listadapter : RecyclerView.Adapter<AudioViewHolder>() {

    private var results = emptyList<Pair<String, List<Results>>>()
    private var artists = emptyList<artist>()

    fun submitList(todoList: List<Pair<String, List<Results>>>) {
        results = todoList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):AudioViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return AudioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        holder.binding.root.setOnClickListener {
            holder.binding.artistrecyclerview.isVisible = !holder.binding.artistrecyclerview.isVisible
        }
        holder.binding.artistname.text = results[position].first
        val artistAdapter = ArtistAdapter()
        holder.binding.artistrecyclerview.adapter = artistAdapter

        artistAdapter.submitList(results[position].second)


    }

    override fun getItemCount() = results.size

}

class AudioViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)