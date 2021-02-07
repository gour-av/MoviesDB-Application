package com.masai_technology.moviesapplication

import com.masai_technology.moviesapplication.database.UsersMovie
import com.masai_technology.moviesapplication.model.ResultsItem

interface ItemClickListener {
      fun onDeleteClicked(usersMovie:UsersMovie)
}