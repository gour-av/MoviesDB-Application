package com.masai_technology.moviesapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.masai_technology.moviesapplication.listeners.ItemClickListener
import com.masai_technology.moviesapplication.R
import com.masai_technology.moviesapplication.adapter.ListMovieAdapter
import com.masai_technology.moviesapplication.database.UsersMovie
import com.masai_technology.moviesapplication.viewmodel.ListUsersMovieViewModel
import com.masai_technology.moviesapplication.viewmodelfactory.ListsUsersViewModelFactory
import kotlinx.android.synthetic.main.activity_watch_list.*

/**
 * This activity is basically showing the users their watchlists
 */
class WatchListActivity : AppCompatActivity(), ItemClickListener {
    private var userList = emptyList<UsersMovie>()
    private lateinit var userListAdapter: ListMovieAdapter
    private lateinit var userListViewModel: ListUsersMovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watch_list)
        /***
         * Here we are getting the instances of the view model class
         */
        userListViewModel = ListsUsersViewModelFactory(this).create(ListUsersMovieViewModel::class.java)
        /***
         * Here we are fetching the data from the database with the help of live data
         */
        userListViewModel.fetchDataFromDB().observe(this, Observer {
            it?.let {
                this@WatchListActivity.userList = it
                userListAdapter.updateData(userList)
            }
        })
        setRecyclerAdapter()
    }

    /***
     * Here we are setting recycler adapter
     */

    private fun setRecyclerAdapter() {
        userListAdapter = ListMovieAdapter(userList,this)
        val linearLayoutManager = GridLayoutManager(this,3)
        recycler_view_watch_list.layoutManager = linearLayoutManager
        recycler_view_watch_list.adapter = userListAdapter
    }

    /**
     * This clicks handles by deleting the selected  particular movie which the user wanted to delete from the database
     */
    override fun onDeleteClicked(usersMovie: UsersMovie) {
           userListViewModel.deleteUser(usersMovie)
    }
}