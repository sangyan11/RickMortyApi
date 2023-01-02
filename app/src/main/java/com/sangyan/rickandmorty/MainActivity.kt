package com.sangyan.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RickRecycler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = RickRecycler()
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = adapter
        RetrofitInstance.api.getDetails().enqueue(object :Callback<RickMorty>{
            override fun onResponse(call: Call<RickMorty>, response: Response<RickMorty>) {
                   if (response.body()!=null){
                      adapter.setData(response.body()!!.results)
                   }
                 else{
                     return
                   }
            }

            override fun onFailure(call: Call<RickMorty>, t: Throwable) {
               Log.d("TAG",t.message.toString())
            }

        })
    }
}