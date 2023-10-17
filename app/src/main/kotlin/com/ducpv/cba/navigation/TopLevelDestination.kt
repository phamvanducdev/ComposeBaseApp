package com.ducpv.cba.navigation

enum class TopLevelDestination(
    val startRoute: String,
    val graphRoute: String
) {
    Home(
        startRoute = NavDestinations.Home.route,
        graphRoute = "home_graph",
    ),
}