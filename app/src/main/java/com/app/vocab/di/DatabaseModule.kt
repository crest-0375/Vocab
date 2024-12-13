package com.app.vocab.di

import android.app.Application
import androidx.room.Room
import com.app.vocab.core.data.database.AppDatabase
import com.app.vocab.features.home.domain.dao.WordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "app_database").build()
    }

    @Singleton
    @Provides
    fun provideWordDao(database: AppDatabase): WordDao {
        return database.wordDao()
    }
}
