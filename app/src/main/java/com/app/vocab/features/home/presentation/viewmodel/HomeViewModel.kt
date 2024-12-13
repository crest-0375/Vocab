package com.app.vocab.features.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.app.vocab.features.home.data.repository.entities.WordEntity
import com.app.vocab.features.home.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
    fun clearData() {
        viewModelScope.launch {
            homeRepository.clearData()
        }
    }

    val words: Flow<PagingData<WordEntity>> = homeRepository.getWords().cachedIn(viewModelScope)
}