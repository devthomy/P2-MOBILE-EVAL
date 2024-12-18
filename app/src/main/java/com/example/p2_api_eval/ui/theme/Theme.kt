package com.example.p2_api_eval.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

/*
*Gestion du dark/light theme
 */
private val LightColorScheme = lightColorScheme(
    primary = BlueDark,
    onPrimary = White,
    secondary = Gold,
    onSecondary = BlueDark,
    background = White,
    onBackground = BlueDark,
    surface = White,
    onSurface = BlueDark
)

private val DarkColorScheme = darkColorScheme(
    primary = Gold,
    onPrimary = DarkGray,
    secondary = BlueDark,
    onSecondary = White,
    background = DarkGray,
    onBackground = White,
    surface = DarkGray,
    onSurface = White
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
