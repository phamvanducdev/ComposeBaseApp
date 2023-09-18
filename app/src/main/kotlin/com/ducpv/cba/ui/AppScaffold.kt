package com.ducpv.cba.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll

/**
 * Created by pvduc9773 on 21/04/2023.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    snackHostState: SnackbarHostState,
    content: @Composable (PaddingValues) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        snackbarHost = { SnackbarHost(snackHostState) },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        content = content,
    )
}