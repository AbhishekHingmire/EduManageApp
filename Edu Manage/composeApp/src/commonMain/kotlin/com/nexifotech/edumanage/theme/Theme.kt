package com.nexifotech.edumanage.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    background = Background,
    surface = CardBackground,
    primary = PrimaryColor,
    secondary = SecondaryColorColor,
    onBackground = TextColorPrimary,
    onSurface = TextColorPrimary,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

private val DarkColors = darkColorScheme(
    background = BackgroundDark,
    surface = CardBackgroundDark,
    primary = PrimaryColorDark,
    secondary = SecondaryColorColorDark,
    onBackground = TextColorPrimaryDark,
    onSurface = TextColorPrimaryDark,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme)DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content= content
    )

}