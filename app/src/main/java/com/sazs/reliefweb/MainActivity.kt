package com.sazs.reliefweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        createData()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter
        }
    }

    fun createData(){
        val item = ArrayList<RecyclerData>()
        item.add(RecyclerData("Java","JavaDescription"))
        item.add(RecyclerData("Kotlin","KotlinDescription"))
        item.add(RecyclerData("Android","AndroidDescription"))

        recyclerViewAdapter.setListData(item)
        recyclerViewAdapter.notifyDataSetChanged()
    }
}