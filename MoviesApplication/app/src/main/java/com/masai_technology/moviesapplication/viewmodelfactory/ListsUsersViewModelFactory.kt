package com.masai_technology.moviesapplication.viewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.masai_technology.moviesapplication.viewmodel.ListUsersMovieViewModel

class ListsUsersViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListUsersMovieViewModel::class.java)) {
            return ListUsersMovieViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}