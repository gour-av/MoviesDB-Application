package com.masai_technology.moviesapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai_technology.moviesapplication.ItemClickListener
import com.masai_technology.moviesapplication.MovieItemClickListener
import com.masai_technology.moviesapplication.R
import com.masai_technology.moviesapplication.model.ResultsItem


import com.masai_technology.moviesapplication.viewholder.MoviesViewHolder

class MoviesAdapter(private var resultsItem: List<ResultsItem>,private val movieItemClickListener: MovieItemClickListener):  RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MoviesViewHolder(view,movieItemClickListener)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val model = resultsItem[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
      return resultsItem.size
    }
    fun updateList(modelList: List<ResultsItem>){
        resultsItem = modelList
        notifyDataSetChanged()
    }
}