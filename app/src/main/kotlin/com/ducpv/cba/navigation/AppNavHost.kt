package com.ducpv.cba.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.ducpv.cba.feature.home.HomeScreen
import com.ducpv.cba.feature.settings.SettingsScreen

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
                HomeScreen(appState)
            }
            composable(route = NavDestinations.Settings.route) {
                SettingsScreen(appState)
            }
        }
    }
}