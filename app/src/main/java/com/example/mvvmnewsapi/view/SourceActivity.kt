package com.example.mvvmnewsapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmnewsapi.adapter.SourceAdapter
import com.example.mvvmnewsapi.databinding.ActivitySourceBinding
import com.example.mvvmnewsapi.viewmodel.SourceViewModel

class SourceActivity : AppCompatActivity() {

    lateinit var binding : ActivitySourceBinding
    lateinit var sourceAdapter: SourceAdapter
    lateinit var sourceVm : SourceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sourceVm = ViewModelProvider(this).get(SourceViewModel::class.java)
        sourceAdapter = SourceAdapter(ArrayList())
        sourceVm.getDataSource().observe(this, Observer {
            sourceAdapter = SourceAdapter(it)
            val layoutMan = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvSource.layoutManager = layoutMan
            binding.rvSource.adapter = sourceAdapter
        })

        val datacategory = intent.extras!!.getString("name")
        sourceVm.callApiSource(datacategory.toString())
    }
}