package com.napptilus.willywonka.commonsui.compose.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode
import com.napptilus.willywonka.commonsui.compose.theme.providers.AppTheme
import com.napptilus.willywonka.commonsui.compose.theme.providers.ThemeColors
import com.napptilus.willywonka.commonsui.compose.theme.providers.buildDark
import com.napptilus.willywonka.commonsui.compose.theme.providers.buildLight
import com.napptilus.willywonka.commonsui.compose.theme.providers.isDarkTheme
import com.napptilus.willywonka.commonsui.compose.theme.providers.toMaterialColors
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColorPalette = ThemeColors.buildLight()

private val DarkColorPalette = ThemeColors.buildDark()

enum class ThemeMode {
    FollowSystem,
    Light,
    Dark,
}

@Composable
fun WillyWonkaTheme(
    themeMode: ThemeMode = ThemeMode.FollowSystem,
    content: @Composable () -> Unit,
) {
    val isDarkTheme = themeMode.isDarkTheme()
    val colorScheme = if (isDarkTheme) DarkColorPalette else LightColorPalette

    if (!isLoadedFromPreview()) {
        val systemUiController = rememberSystemUiController()
        systemUiController.setStatusBarColor(
            color = colorScheme.surface,
            darkIcons = !isDarkTheme,
        )
    }

    AppTheme(colorScheme) {
        MaterialTheme(
            colorScheme = colorScheme.toMaterialColors(),
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

@Composable
private fun isLoadedFromPreview() = LocalInspectionMode.current
