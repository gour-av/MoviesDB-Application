package com.masai_technology.moviesapplication.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.masai_technology.moviesapplication.database.DatabaseClient
import com.masai_technology.moviesapplication.database.UsersMovie
import com.masai_technology.moviesapplication.model.ResultsItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DBListMovieRepository(private val context: Context) {
    fun fetchDataFromDB(): LiveData<List<UsersMovie>> {
        return DatabaseClient.getInstance(context)
            .resultDao.getWatchList()
    }



    fun deleteUser(user: UsersMovie) {
        CoroutineScope(Dispatchers.IO).launch {
            DatabaseClient.getInstance(context).resultDao.removeWatchList(user)

        }
    }
}