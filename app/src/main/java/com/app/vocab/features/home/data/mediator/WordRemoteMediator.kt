package com.app.vocab.features.home.data.mediator

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.app.vocab.core.data.networking.ApiService
import com.app.vocab.core.domain.util.Result
import com.app.vocab.features.home.data.repository.entities.WordEntity
import com.app.vocab.features.home.domain.dao.WordDao
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class WordRemoteMediator(
    private val apiService: ApiService,
    private val wordDao: WordDao
) : RemoteMediator<Int, WordEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, WordEntity>
    ): MediatorResult {

        when (loadType) {
            LoadType.REFRESH -> {
                1
            }
            LoadType.PREPEND -> {
                return MediatorResult.Success(endOfPaginationReached = true)
            }
            LoadType.APPEND -> {
                state.pages.size + 1
            }
        }

        return try {
            val response = apiService.fetchWords()
            if (response is Result.Success) {
                val entities = response.data.map { WordEntity(word = it, description = "") }

                wordDao.insertWordsToDatabase(entities)
                MediatorResult.Success(endOfPaginationReached = entities.isEmpty())
            } else {
                MediatorResult.Error(Exception("Response Failed"))
            }
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}
