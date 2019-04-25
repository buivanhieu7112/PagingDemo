package com.example.pagingdemo.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pagingdemo.data.model.Repo
import io.reactivex.Flowable

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: List<Repo>)

    @Query("SELECT * FROM repos WHERE(name LIKE :queryString) OR(description LIKE :queryString) ORDER BY stars DESC, name ASC")
    fun reposByName(queryString: String): Flowable<List<Repo>>
}
