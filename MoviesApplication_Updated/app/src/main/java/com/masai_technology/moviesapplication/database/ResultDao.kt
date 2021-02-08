package com.masai_technology.moviesapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.masai_technology.moviesapplication.model.ResultsItem

/***
 * This is the Dao Interface where we write all Queries
 * */
@Dao
interface ResultDao {
    @Insert
    suspend fun insertWatchList(resutItem: UsersMovie)

    /***
    This will return a LiveData<List<UsersMovie>> , so whenever the database is changed the observer
    is notified
     */
    @Query("Select * From Users")
    fun getWatchList(): LiveData<List<UsersMovie>>



    @Delete
    fun removeWatchList(resutItem: UsersMovie)
}