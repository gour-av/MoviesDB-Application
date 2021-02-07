package com.masai_technology.moviesapplication.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.masai_technology.moviesapplication.repositories.DBMovieRepository

class UsersMovieViewModel(private val context: Context): ViewModel() {
    private val repository = DBMovieRepository()

    fun insertDataToDatabase(title:String,image:String){
        repository.insertDataToDatabase(title,image,context)
    }
}