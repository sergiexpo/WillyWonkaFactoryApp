package com.napptilus.willywonka.commonsui.compose.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.napptilus.willywonka.commonsui.compose.theme.providers.AppTheme
import com.napptilus.willywonka.commonsui.compose.theme.providers.LocalDisabledAlpha


@Composable
fun SingleActionButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        shape = CircleShape,
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.primary,
            contentColor = AppTheme.colors.surface
        ),
        onClick = onClick,
    ) {
        Text(
            text = text,
        )
    }
}

