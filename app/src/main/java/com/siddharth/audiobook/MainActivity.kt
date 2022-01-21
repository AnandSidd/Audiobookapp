package com.siddharth.audiobook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import com.siddharth.audiobook.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    lateinit var data : List<Results>
    lateinit var artgrp : List<Pair<String, List<Results>>>
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val lsadapter = listadapter()
        binding.recycle.adapter = lsadapter
        binding.shuffle.setOnClickListener {
            lsadapter.submitList(artgrp.shuffled())
        }
        GlobalScope.launch {
            data = apiService.getdata().results
            artgrp = data.groupBy {
                it.artistName
            }.toList()
            withContext(Dispatchers.Main){
                binding.progressBar.isVisible = false
                lsadapter.submitList(artgrp)

            }
        }

    }
}