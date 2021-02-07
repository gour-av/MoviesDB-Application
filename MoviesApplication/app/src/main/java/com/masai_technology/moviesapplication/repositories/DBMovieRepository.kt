package com.masai_technology.moviesapplication.repositories

import android.content.Context
import com.masai_technology.moviesapplication.database.DatabaseClient
import com.masai_technology.moviesapplication.database.UsersMovie
import com.masai_technology.moviesapplication.model.ResultsItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DBMovieRepository {
    fun insertDataToDatabase(title: String, image: String, context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            val user =
                UsersMovie(title = title, image = image)
            DatabaseClient.getInstance(context).resultDao.insertWatchList(user)
        }
    }
}