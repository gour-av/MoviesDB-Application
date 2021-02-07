package com.masai_technology.moviesapplication

import com.masai_technology.moviesapplication.database.UsersMovie
import com.masai_technology.moviesapplication.model.ResultsItem

interface MovieItemClickListener {
    fun onItemClicked(resultsItem: ResultsItem)
}