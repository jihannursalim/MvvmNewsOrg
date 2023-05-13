package com.example.mvvmnewsapi.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmnewsapi.model.Source
import com.example.mvvmnewsapi.networking.ApiClient
import com.example.mvvmnewsapi.networking.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SourceViewModel @Inject constructor(var api : ApiService) : ViewModel() {

    lateinit var liveDataSource : MutableLiveData<List<Source>?>

    init {
        liveDataSource = MutableLiveData()
    }

    fun getDataSource() : MutableLiveData<List<Source>?> {
        return liveDataSource
    }

    fun callApiSource(category : String){
//        ApiClient.instance.getAllSources(category)
        api.getAllSources(category)
            .enqueue(object : Callback<List<Source>>{
                override fun onResponse(
                    call: Call<List<Source>>,
                    response: Response<List<Source>>
                ) {
                    if (response.isSuccessful){
                        liveDataSource.postValue(response.body())
                    }else{
                        liveDataSource.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<Source>>, t: Throwable) {
                    liveDataSource.postValue(null)
                }


            })
    }

}