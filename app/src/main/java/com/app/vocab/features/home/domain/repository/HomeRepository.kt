package com.app.vocab.features.home.domain.repository

import androidx.paging.PagingData
import com.app.vocab.features.home.data.repository.entities.WordEntity
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getWords(): Flow<PagingData<WordEntity>>
    suspend fun clearData()
}