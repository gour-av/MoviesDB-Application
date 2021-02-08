package com.masai_technology.moviesapplication.network


import com.masai_technology.moviesapplication.model.MoviesModel

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIClient {
    @GET("/3/movie/popular?api_key=f93f2306dd57a8d5c1932faa0774cd16")
   /* fun getTrending(@Query("page")page:Int) : Call<MoviesModel>*/

   fun getTrending() : Call<MoviesModel>

}