package com.app.vocab.routes

import kotlinx.serialization.Serializable

sealed class RootRoute {

    @Serializable
    data object AuthNavGraph : RootRoute()

    @Serializable
    data object AppNavGraph : RootRoute()
}