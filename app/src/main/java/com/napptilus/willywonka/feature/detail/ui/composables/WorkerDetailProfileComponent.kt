package com.napptilus.willywonka.feature.detail.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.napptilus.willywonka.commonsui.compose.theme.providers.AppTheme

@Composable
fun WorkerDetailProfileComponent(
    label: String,
    text: String
) {
    Column(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            )
    ) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = AppTheme.typography.bodySmall,
        )
        Text(
            text = text,
            modifier = Modifier.height(24.dp),
            style = AppTheme.typography.bodyLarge,
        )
    }
}