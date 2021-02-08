package com.masai_technology.moviesapplication.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai_technology.moviesapplication.listeners.MovieItemClickListener
import com.masai_technology.moviesapplication.database.DatabaseClient
import com.masai_technology.moviesapplication.database.UsersMovie
import com.masai_technology.moviesapplication.model.ResultsItem

import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewHolder(private val view: View,var movieItemClickListener: MovieItemClickListener): RecyclerView.ViewHolder(view) {
    fun setData(resultsItem: ResultsItem){
        view.apply {



            Glide.with(img_poster_show).load("https://image.tmdb.org/t/p/w500/" +
                    resultsItem.posterPath).into(img_poster_show)
           textName.text = resultsItem.title
            constraint_layout.setOnClickListener(View.OnClickListener {
                    movieItemClickListener.onItemClicked(resultsItem)
            })
            img_favorite.setOnCheckedChangeListener { checkBox, isChecked ->

                if (isChecked) {
                    CoroutineScope(Dispatchers.IO).launch {
                        val user =
                            UsersMovie(
                                title = resultsItem.originalTitle.toString(),
                                image = resultsItem.posterPath.toString()
                            )
                        DatabaseClient.getInstance(context).resultDao.insertWatchList(user)
                    }
                } else {

                   


                }
            }
        }
    }

}