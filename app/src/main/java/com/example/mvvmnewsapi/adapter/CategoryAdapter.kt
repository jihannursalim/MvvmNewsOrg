package com.example.mvvmnewsapi.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmnewsapi.databinding.ItemCategoryBinding
import com.example.mvvmnewsapi.model.CategoryData

class CategoryAdapter(var listCategory : List<CategoryData>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var onClick : ((CategoryData) -> Unit)? = null

    class ViewHolder(var binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        val view = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        holder.binding.txtCategory.text = listCategory[position].name
        Glide.with(holder.itemView).load(listCategory[position].picture).into(holder.binding.imgCategory)
        holder.binding.itemCategory.setOnClickListener {
            Log.d("cat", listCategory[position].name)
            Toast.makeText(holder.itemView.context, listCategory[position].name, Toast.LENGTH_SHORT).show()
            onClick!!.invoke(listCategory[position])
        }
    }

    override fun getItemCount(): Int {
        return listCategory.size
    }
}