package com.app.vocab.features.home.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.app.vocab.core.data.networking.ApiService
import com.app.vocab.features.home.data.mediator.WordRemoteMediator
import com.app.vocab.features.home.data.repository.entities.WordEntity
import com.app.vocab.features.home.domain.dao.WordDao
import com.app.vocab.features.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//  <--- this is best example to work with ktor --->
//class HomeRepositoryImpl @Inject constructor(private val client: HttpClient) : HomeRepository {
//    override suspend fun getWords(): Result<List<Word>, NetworkError> {
//        return safeCall<WordsResponseDto> {
//            client.get(constructUrl(""))
//        }.map { response ->
//            response.data.map { it.toWord() }
//        }
//    }
//}

class HomeRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val wordDao: WordDao
) : HomeRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getWords(): Flow<PagingData<WordEntity>> {
        return Pager(
            config = PagingConfig(pageSize = 50),
            remoteMediator = WordRemoteMediator(apiService, wordDao),
            pagingSourceFactory = { wordDao.getDatabaseWords() }
        ).flow
    }

    override suspend fun clearData() {
        wordDao.clearData()
    }
}