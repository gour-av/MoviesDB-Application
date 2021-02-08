package com.masai_technology.moviesapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.masai_technology.moviesapplication.model.ResultsItem

/***
 * This is the database Client class  through which we can able to  manage our room database part
 */
@Database(entities = [UsersMovie::class], version = 1, exportSchema = false)
abstract class DatabaseClient:RoomDatabase() {
    abstract val resultDao:ResultDao

    companion object {

        private var INSTANCE: DatabaseClient? = null

        fun getInstance(context: Context): DatabaseClient {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, DatabaseClient::class.java, "Users_DB").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
