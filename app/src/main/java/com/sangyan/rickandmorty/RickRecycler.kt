package com.sangyan.rickandmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_layout.view.*

class RickRecycler : RecyclerView.Adapter<RickRecycler.ViewHolder>() {
    var list = ArrayList<Result>()
    fun setData(list  : List<Result>){
        this.list = list as ArrayList<Result>
        notifyDataSetChanged()
    }
    class ViewHolder(view : View)  : RecyclerView.ViewHolder(view){
       val id = view.showID
        val  name = view.showName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = list[position].id.toString()
        holder.name.text = list[position].name
    }

    override fun getItemCount(): Int {
       return list.size
    }
}