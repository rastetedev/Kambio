package com.raulastete.kambio.presentation.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KambioTopBar(
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    title: String
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors().copy(
            containerColor = Color.Transparent
        ),
        navigationIcon = navigationIcon,
        title = {
            Text(title)
        }
    )
}