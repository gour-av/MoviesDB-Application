package com.masai_technology.moviesapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.masai_technology.moviesapplication.adapter.ListMovieAdapter
import com.masai_technology.moviesapplication.database.UsersMovie
import com.masai_technology.moviesapplication.model.ResultsItem
import com.masai_technology.moviesapplication.viewmodel.ListUsersMovieViewModel
import com.masai_technology.moviesapplication.viewmodelfactory.ListsUsersViewModelFactory
import kotlinx.android.synthetic.main.activity_watch_list.*

class WatchListActivity : AppCompatActivity(),ItemClickListener {
    private var userList = emptyList<UsersMovie>()
    private lateinit var userListAdapter: ListMovieAdapter
    private lateinit var userListViewModel: ListUsersMovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watch_list)
        userListViewModel = ListsUsersViewModelFactory(this).create(ListUsersMovieViewModel::class.java)

        userListViewModel.fetchDataFromDB().observe(this, Observer {
            it?.let {
                this@WatchListActivity.userList = it
                userListAdapter.updateData(userList)
            }
        })
        setRecyclerAdapter()
    }

    private fun setRecyclerAdapter() {
        userListAdapter = ListMovieAdapter(userList,this)
        val linearLayoutManager = GridLayoutManager(this,3)
        recycler_view_watch_list.layoutManager = linearLayoutManager
        recycler_view_watch_list.adapter = userListAdapter
    }

    override fun onDeleteClicked(usersMovie: UsersMovie) {
           userListViewModel.deleteUser(usersMovie)
    }
}