package com.app.vocab.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.vocab.features.home.data.repository.entities.WordEntity
import com.app.vocab.features.home.domain.dao.WordDao

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}
