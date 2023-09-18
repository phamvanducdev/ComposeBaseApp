package com.ducpv.cba.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

/**
 * Created by pvduc9773 on 03/04/2023.
 */
@Composable
fun AppNavHost(appState: AppState) {
    NavHost(
        navController = appState.navController,
        startDestination = TopLevelDestination.Home.graphRoute,
    ) {
        navigation(
            route = TopLevelDestination.Home.graphRoute,
            startDestination = NavDestinations.Home.route,
        ) {
            composable(route = NavDestinations.Home.route) {
                Text(text = "Home Screen")
            }
        }
    }
}