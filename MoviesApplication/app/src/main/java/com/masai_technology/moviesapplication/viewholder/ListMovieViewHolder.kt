package com.masai_technology.moviesapplication.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai_technology.moviesapplication.ItemClickListener
import com.masai_technology.moviesapplication.database.UsersMovie
import com.masai_technology.moviesapplication.model.ResultsItem
import kotlinx.android.synthetic.main.item_watch_list.view.*

class ListMovieViewHolder(private val view: View,
                          private val listener: ItemClickListener):RecyclerView.ViewHolder(view) {
    fun setData(user: UsersMovie) {
        view.apply {
            textNameList.text = user.title
            Glide.with(img_poster_list).load(
                "https://image.tmdb.org/t/p/w500/" +
                        user.image
            ).into(img_poster_list)
            img_delete.setOnClickListener {
                listener.onDeleteClicked(user)
            }
        }
    }
}