package com.siddharth.audiobook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.siddharth.audiobook.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    lateinit var data : List<Results>
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val lsadapter = listadapter()
        binding.recycle.adapter = lsadapter
        GlobalScope.launch {
            data = apiService.getdata().results
            withContext(Dispatchers.Main){
                lsadapter.submitList(data)
            }
        }
        binding.shuffle.setOnClickListener {
            lsadapter.submitList(data.shuffled())
        }

    }
}