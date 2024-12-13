package com.app.vocab.routes

import kotlinx.serialization.Serializable

sealed class AppRoute {

    val name: String
        get() = this::class.qualifiedName ?: (this::class.simpleName ?: this::class.toString())

    @Serializable
    data object HomeAppRoute : AppRoute()

}