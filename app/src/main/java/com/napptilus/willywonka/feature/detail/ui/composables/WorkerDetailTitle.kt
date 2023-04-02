package com.napptilus.willywonka.feature.detail.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.napptilus.willywonka.commonsui.compose.theme.providers.AppTheme

@Composable
fun WorkerDetailTitle(title: String) {
    Column(
        modifier = Modifier
            .padding(all = 16.dp)
    ) {
        Text(
            text = title,
            style = AppTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}