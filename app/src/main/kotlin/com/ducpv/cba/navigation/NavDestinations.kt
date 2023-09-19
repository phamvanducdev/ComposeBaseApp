package com.ducpv.cba.navigation

import androidx.annotation.StringRes

enum class NavDestinations(
    val route: String,
    @StringRes val label: Int? = null,
) {
    Home("home_route"),
    Settings("settings_route");

    companion object {
        fun findByRoute(route: String?): NavDestinations? {
            return values().find { it.route == route }
        }
    }
}