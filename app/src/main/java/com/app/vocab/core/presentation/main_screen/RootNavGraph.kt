package com.app.vocab.core.presentation.main_screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.vocab.animation.AnimateScreen
import com.app.vocab.features.auth.presentation.navigation.AuthNavGraph
import com.app.vocab.features.home.presentation.navigation.AppNavGraph
import com.app.vocab.routes.RootRoute.AppNavGraph
import com.app.vocab.routes.RootRoute.AuthNavGraph

@Composable
fun RootNavGraph(
    rootNavController: NavHostController,
    startDestination: Any,
    onBackOrFinish: () -> Unit,
) {
    Scaffold(
        content = { innerPadding ->
            NavHost(
                navController = rootNavController,
                startDestination = startDestination
            ) {

                composable<AuthNavGraph>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    AuthNavGraph(
                        innerPadding = innerPadding,
                        onBackOrFinish = onBackOrFinish,
                        onOnboardingSuccess = {
                            rootNavController.navigate(AppNavGraph) {
                                popUpTo(AuthNavGraph) {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }

                composable<AppNavGraph>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    AppNavGraph(
                        innerPadding = innerPadding,
                        onBackOrFinish = onBackOrFinish,
                        onSignOut = {
                            rootNavController.navigate(AuthNavGraph) {
                                popUpTo(AppNavGraph) {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }
            }
        }
    )
}