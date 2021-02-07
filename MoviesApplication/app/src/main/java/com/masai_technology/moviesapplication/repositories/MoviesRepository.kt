package com.masai_technology.moviesapplication.repositories


import com.masai_technology.moviesapplication.model.MoviesModel
import com.masai_technology.moviesapplication.network.APIClient
import com.masai_technology.moviesapplication.network.Network

import retrofit2.Callback

class MoviesRepository(private val callback: Callback<MoviesModel>) {

    fun getListOfMovies() {
        val apiClient = Network.getInstance().create(APIClient::class.java)
        val call = apiClient.getTrending()

        call.enqueue(callback)
    }
}