package com.napptilus.willywonka.commonsui.compose.theme.providers

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.napptilus.willywonka.commonsui.compose.theme.ThemeMode

@Composable
@ReadOnlyComposable
fun ThemeMode.isDarkTheme(): Boolean =
    this == ThemeMode.Dark || (this == ThemeMode.FollowSystem && isSystemInDarkTheme())
