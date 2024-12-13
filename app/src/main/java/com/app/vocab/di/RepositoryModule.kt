package com.app.vocab.di

import com.app.vocab.core.data.networking.ApiService
import com.app.vocab.features.auth.data.AuthRepositoryImpl
import com.app.vocab.features.auth.domain.repository.AuthRepository
import com.app.vocab.features.home.data.repository.HomeRepositoryImpl
import com.app.vocab.features.home.domain.dao.WordDao
import com.app.vocab.features.home.domain.repository.HomeRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(
        apiService: ApiService,
        wordDao: WordDao
    ): HomeRepository = HomeRepositoryImpl(apiService, wordDao)


    @Provides
    @Singleton
    fun provideAuthRepository(
        firebaseAuth: FirebaseAuth
    ): AuthRepository = AuthRepositoryImpl(firebaseAuth)
}