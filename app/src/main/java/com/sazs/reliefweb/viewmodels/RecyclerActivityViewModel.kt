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

    lateinit var recyclerListData: MutableLiveData<RecyclerList>

    init{
        recyclerListData = MutableLiveData()
    }

    fun getRecyclerListDataObserver(): MutableLiveData<RecyclerList>{
        return recyclerListData
    }

    fun makeApiCall(){
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromAPI("network")
        call.enqueue(object: Callback<RecyclerList> {
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if(response.isSuccessful){
//                    recyclerViewAdapter.setListData(response.body()?.items!!)
//                    recyclerViewAdapter.notifyDataSetChanged()
                    recyclerListData.postValue(response.body())
                }
                else recyclerListData.postValue(null)
            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "Error in getting data from API", Toast.LENGTH_SHORT).show()
                recyclerListData.postValue(null)
            }
        })
    }
}