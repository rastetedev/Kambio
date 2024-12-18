package com.raulastete.kambio.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val DarkColorScheme = darkColorScheme(
    primary = KambioPrimary,
    background = KambioBlack,
    surface = KambioBlackVariant,
    secondary = KambioWhite,
    tertiary = KambioWhite,
    primaryContainer = KambioPrimary30,
    onPrimary = KambioBlack,
    onBackground = KambioWhite,
    onSurface = KambioWhite,
    onSurfaceVariant = KambioWhiteVariant,
    error = KambioDarkRed
)

val LightColorScheme = lightColorScheme(
    primary = KambioPrimaryLight,
    background = KambioWhite,
    surface = KambioWhiteVariant,
    secondary = KambioBlack,
    tertiary = KambioBlack,
    primaryContainer = KambioPrimaryLight30,
    onPrimary = KambioWhite,
    onBackground = KambioBlack,
    onSurface = KambioBlack,
    onSurfaceVariant = KambioBlackVariant,
    error = KambioDarkRed
)

@Composable
fun KambioTheme(
    isDarkTheme : Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if(isDarkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isDarkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = !isDarkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}