package com.app.vocab.core.presentation.utils

import com.app.vocab.core.domain.util.Preferences
import com.app.vocab.routes.RootRoute
import com.app.vocab.routes.RootRoute.AppNavGraph

object Utils {
    fun getStartDestination(): Any {
        return if (Preferences.getIsOnboarded()) AppNavGraph
        else RootRoute.AuthNavGraph
    }
}