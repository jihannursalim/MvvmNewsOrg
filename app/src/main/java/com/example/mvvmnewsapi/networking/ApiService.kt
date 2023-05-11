package com.example.mvvmnewsapi.networking

import com.example.mvvmnewsapi.model.Source
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines/source")
    fun getAllSources(
        @Query("category") category : String,
        @Query("apikey") apikey : String = "cd459e27cc2641ca9730cb92b61828ce"
    ) : Call<List<Source>>


}