package com.masai_technology.moviesapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masai_technology.moviesapplication.model.MoviesModel
import com.masai_technology.moviesapplication.model.ResultsItem


import com.masai_technology.moviesapplication.repositories.MoviesRepository
import com.masai_technology.moviesapplication.ui.MoviesUIModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/***
 * This is the viewmodel class where we are getting the response from the api using retrofit
 */
class MoviesViewModel:ViewModel(),Callback<MoviesModel> {
    private val repository = MoviesRepository(this)

    private val mutableLiveData = MutableLiveData<MoviesUIModel>()

    val liveData: LiveData<MoviesUIModel> = mutableLiveData
    override fun onResponse(call: Call<MoviesModel>, response: Response<MoviesModel>) {
        response.body()?.let {
            mutableLiveData.value = MoviesUIModel.Success(it.results as List<ResultsItem>)
        }
    }

    override fun onFailure(call: Call<MoviesModel>, t: Throwable) {
        mutableLiveData.value = MoviesUIModel.Failure(t.message!!)



    }
    fun callAPI() {
        repository.getListOfMovies()
    }
}