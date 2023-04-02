package com.napptilus.willywonka.commonsui.navigation.transition

import androidx.compose.runtime.Immutable

@Immutable
data class MotionTransition(
    val transitionSlide: Int,
    val transitionInitialScale: Float,
    val transitionTargetScale: Float,
    val transitionDuration: Long,
)
