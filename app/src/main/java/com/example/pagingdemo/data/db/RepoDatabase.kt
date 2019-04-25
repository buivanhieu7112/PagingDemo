package com.example.pagingdemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pagingdemo.data.db.RepoDatabase.Companion.DATABASE_VERSION
import com.example.pagingdemo.data.model.Repo

@Database(entities = [Repo::class], version = DATABASE_VERSION, exportSchema = false)
abstract class RepoDatabase: RoomDatabase(){
    abstract fun repoDao(): RepoDao

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Github.db"
    }
}
