package com.raulastete.kambio.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val DarkColorScheme = darkColorScheme(
    primary = KambioPrimary,
    background = KambioBlack,
    surface = KambioDarkGray,
    secondary = KambioWhite,
    tertiary = KambioWhite,
    primaryContainer = KambioPrimary30,
    onPrimary = KambioBlack,
    onBackground = KambioWhite,
    onSurface = KambioWhite,
    onSurfaceVariant = KambioWhiteVariant,
    error = KambioDarkRed
)

@Composable
fun KambioTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}