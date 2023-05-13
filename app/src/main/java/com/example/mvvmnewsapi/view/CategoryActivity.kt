package com.example.mvvmnewsapi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmnewsapi.R
import com.example.mvvmnewsapi.adapter.CategoryAdapter
import com.example.mvvmnewsapi.databinding.ActivityCategoryBinding
import com.example.mvvmnewsapi.model.CategoryData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryActivity : AppCompatActivity() {

    lateinit var binding: ActivityCategoryBinding
    lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listCategory = arrayListOf(
            CategoryData("BUSINESS",R.drawable.business),
            CategoryData("ENTERTAINMENT",R.drawable.entertainment),
            CategoryData("GENERAL",R.drawable.general),
            CategoryData("HEALTH",R.drawable.health),
            CategoryData("SCIENCE",R.drawable.science),
            CategoryData("SPORTS",R.drawable.sports),
            CategoryData("TECHNOLOGY",R.drawable.technology)
        )

        categoryAdapter = CategoryAdapter(listCategory)
        binding.rvCategory.apply {
            layoutManager = LinearLayoutManager(this@CategoryActivity, LinearLayoutManager.VERTICAL, false)
            adapter = categoryAdapter
            categoryAdapter.onClick = {
                val intent = Intent(context, SourceActivity::class.java)
                val category = it.name
                intent.putExtra("name", category)
                startActivity(intent)
            }
        }
    }
}