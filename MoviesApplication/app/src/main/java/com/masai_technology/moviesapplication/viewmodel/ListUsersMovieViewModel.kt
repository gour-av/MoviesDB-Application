package com.masai_technology.moviesapplication.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.masai_technology.moviesapplication.database.DatabaseClient
import com.masai_technology.moviesapplication.database.UsersMovie
import com.masai_technology.moviesapplication.model.ResultsItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ListUsersMovieViewModel(private val context: Context) : ViewModel() {
    fun fetchDataFromDB(): LiveData<List<UsersMovie>> {
        return DatabaseClient.getInstance(context)
            .resultDao.getWatchList()
    }
    fun deleteUser(user: UsersMovie) {
        CoroutineScope(IO).launch {
            DatabaseClient.getInstance(context).resultDao.removeWatchList(user)

        }
    }
}