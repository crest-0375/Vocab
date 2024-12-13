package com.app.vocab.core.data.networking

import com.app.vocab.core.domain.util.NetworkError
import com.app.vocab.core.domain.util.Result
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(private val client: HttpClient) {

    suspend fun fetchWords(): Result<List<String>, NetworkError> {
        return safeCall<List<String>> {
            client.get(constructUrl("")).body()
        }
    }
}