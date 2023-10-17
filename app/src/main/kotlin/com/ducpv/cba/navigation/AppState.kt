package com.ducpv.cba.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import kotlinx.coroutines.CoroutineScope

/**
 * Created by pvduc9773 on 03/04/2023.
 */
class AppState(
    val coroutineScope: CoroutineScope,
    val navController: NavHostController,
    val snackHostState: SnackbarHostState
) {
    private val topLevelDestinations = TopLevelDestination.values().asList()

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    private val currentTopLevelDestination: TopLevelDestination?
        get() = topLevelDestinations.find {
            it.startRoute == navController.currentDestination?.route
        }

    private val multipleTopDestination: Boolean
        get() = topLevelDestinations.size > 1

    fun onNavigationClick() {
        navController.popBackStack()
    }

    fun navigateToTopLevelDestination(destination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // re-selecting the same item
            launchSingleTop = true
            // Restore state when re-selecting a previously selected item
            restoreState = true
        }
        when (destination) {
            TopLevelDestination.Home -> {
                navController.navigate(destination.graphRoute, topLevelNavOptions)
            }
        }
    }
}

@Composable
fun rememberAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
    snackHostState: SnackbarHostState = remember { SnackbarHostState() },
): AppState {
    return remember(coroutineScope, navController, snackHostState) {
        AppState(
            coroutineScope,
            navController,
            snackHostState,
        )
    }
}