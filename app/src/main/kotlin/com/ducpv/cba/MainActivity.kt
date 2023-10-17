package com.ducpv.cba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.imePadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ducpv.cba.navigation.AppNavHost
import com.ducpv.cba.navigation.AppState
import com.ducpv.cba.navigation.rememberAppState
import com.ducpv.cba.ui.AppScaffold
import com.ducpv.cba.ui.theme.ComposeBaseAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This app draws behind the system bars, so we want to handle fitting system windows
        // WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ComposeBaseAppTheme {
                ComposeBaseApp()
            }
        }
    }
}

@Composable
fun ComposeBaseApp(
    appState: AppState = rememberAppState()
) {
    Box(modifier = Modifier.imePadding()) {
        AppScaffold(
            snackHostState = appState.snackHostState,
        ) {
            AppNavHost(appState = appState)
        }
    }
}