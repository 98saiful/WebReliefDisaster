package com.sazs.reliefweb.viewmodels

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sazs.reliefweb.RecyclerList
import com.sazs.reliefweb.network.RetroInstance
import com.sazs.reliefweb.network.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerActivityViewModel: ViewModel() {

    var recyclerListData: MutableLiveData<RecyclerList> = MutableLiveData()

    fun getRecyclerListDataObserver(): MutableLiveData<RecyclerList>{
        return recyclerListData
    }

    fun makeApiCall(input: String){
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromAPI(input)
        call.enqueue(object: Callback<RecyclerList> {
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if(response.isSuccessful){
                    recyclerListData.postValue(response.body())
                }
                else recyclerListData.postValue(null)
            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                recyclerListData.postValue(null)
            }
        })
    }
}