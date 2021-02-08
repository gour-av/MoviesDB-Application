package com.masai_technology.moviesapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai_technology.moviesapplication.listeners.MovieItemClickListener
import com.masai_technology.moviesapplication.R
import com.masai_technology.moviesapplication.adapter.MoviesAdapter
import com.masai_technology.moviesapplication.model.ResultsItem
import com.masai_technology.moviesapplication.ui.MoviesUIModel


import com.masai_technology.moviesapplication.viewmodel.MoviesViewModel
import com.masai_technology.moviesapplication.viewmodel.UsersMovieViewModel
import com.masai_technology.moviesapplication.viewmodelfactory.UserViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

/**
 * This is the activity class where we are calling the api and getting the response on the screen and along with that also
 * observing the data changes with the help of live data

 */
class MainActivity : AppCompatActivity(), MovieItemClickListener {
    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var usersMovieViewModel: UsersMovieViewModel

    private lateinit var moviesAdapter: MoviesAdapter
    private val moviesModelList = emptyList<ResultsItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        usersMovieViewModel = UserViewModelFactory(this).create(UsersMovieViewModel::class.java)
        setRecyclerAdapter()
        observeLiveData()

        flProgressBar.visibility = View.VISIBLE
       moviesViewModel.callAPI()
        img_eye_task.setOnClickListener(View.OnClickListener {
            val intent1 = Intent(this, WatchListActivity::class.java)
            startActivity(intent1)
        })
    }

    /***
     * Here we are observing the data changes with the help of live data
     */

    private fun observeLiveData() {
          moviesViewModel.liveData.observe(this, Observer {
            when(it){
              is MoviesUIModel.Success ->{
               moviesAdapter.updateList(it.moviesModelList)
                  flProgressBar.visibility = View.GONE
              }
            }
          })
    }

    /***
     * here we are setting the recycler adapter
     */
    private fun setRecyclerAdapter() {
        moviesAdapter = MoviesAdapter(moviesModelList,this)
        val layoutManager = LinearLayoutManager(this)
        recycler_view.apply {
            this.layoutManager = layoutManager
            adapter = moviesAdapter
        }

    }

    override fun onItemClicked(resultsItem: ResultsItem) {

    }


}