package com.masai_technology.moviesapplication.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MoviesModel(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("total_results")
	val totalResults: Float? = null
)