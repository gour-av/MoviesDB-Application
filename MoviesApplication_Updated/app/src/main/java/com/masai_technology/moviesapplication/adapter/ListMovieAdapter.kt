package com.masai_technology.moviesapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai_technology.moviesapplication.listeners.ItemClickListener
import com.masai_technology.moviesapplication.R
import com.masai_technology.moviesapplication.database.UsersMovie
import com.masai_technology.moviesapplication.viewholder.ListMovieViewHolder

class ListMovieAdapter( private var usersList: List<UsersMovie>,
                        private val listener: ItemClickListener
):RecyclerView.Adapter<ListMovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_watch_list, parent, false)
        return ListMovieViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ListMovieViewHolder, position: Int) {
        val user = usersList[position]
        holder.setData(user)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
    fun updateData(userList: List<UsersMovie>) {
        this.usersList = userList
        notifyDataSetChanged()
    }
}