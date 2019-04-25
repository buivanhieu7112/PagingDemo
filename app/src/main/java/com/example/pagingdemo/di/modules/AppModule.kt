package com.example.pagingdemo.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.pagingdemo.data.db.RepoDatabase
import com.example.pagingdemo.data.db.RepoDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideRepoDatabase(application: Application): RepoDatabase {
        return Room.databaseBuilder(application.applicationContext, RepoDatabase::class.java, DATABASE_NAME).build()
    }
}
