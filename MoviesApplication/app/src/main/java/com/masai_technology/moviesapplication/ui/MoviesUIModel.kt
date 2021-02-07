package com.masai_technology.moviesapplication.ui

import com.masai_technology.moviesapplication.model.ResultsItem


sealed class MoviesUIModel {
    data class Success(val moviesModelList: List<ResultsItem>) : MoviesUIModel()

    data class Failure(val error: String) : MoviesUIModel()
}