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

/***
 * This is the view model class where we are fetching the data stored into the room database
 */
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