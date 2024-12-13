package com.app.vocab.routes

import kotlinx.serialization.Serializable

sealed class AuthRoute {

    @Serializable
    data object OnBoardingScreen : AuthRoute()

    @Serializable
    data object SignInScreen : AuthRoute()

    @Serializable
    data object SignUpScreen : AuthRoute()

    @Serializable
    data class ForgotPassScreen(val email: String) : AuthRoute()

}