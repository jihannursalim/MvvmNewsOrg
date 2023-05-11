package com.example.mvvmnewsapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmnewsapi.R
import com.example.mvvmnewsapi.databinding.ActivityArtikelBinding

class ArtikelActivity : AppCompatActivity() {

    lateinit var binding : ActivityArtikelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel)
    }
}