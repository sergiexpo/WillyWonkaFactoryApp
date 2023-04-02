package com.napptilus.willywonka.commonsui.compose.theme.providers

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.napptilus.willywonka.commonsui.compose.theme.ThemeMode
import com.napptilus.willywonka.commonsui.navigation.transition.MotionTransition

@Composable
fun AppTheme(
    themeColors: ThemeColors,
    content: @Composable () -> Unit,
) {
    val motionTransition = defaultMotionTransition.copy(
        transitionSlide = with(LocalDensity.current) { TRANSITION_SLIDE_DPS.dp.toPx().toInt() },
    )
    CompositionLocalProvider(
        LocalMotionDuration provides defaultMotionDuration,
        LocalMotionTransition provides motionTransition,
        LocalColors provides themeColors
    ) {
        content()
    }
}

object AppTheme {
    val colors: ThemeColors
        @Composable
        get() = LocalColors.current

    val typography: Typography
        @Composable
        get() = MaterialTheme.typography
}
