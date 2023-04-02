package com.napptilus.willywonka.feature.home.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.napptilus.willywonka.commonsui.compose.theme.providers.AppTheme
import com.napptilus.willywonka.composables.FilterComponent
import com.napptilus.willywonka.utils.FilterType

@Composable
fun HomeFilterComponent(
    title: String,
    listItems: MutableList<String>,
    filterType: FilterType,
    onFilterItemClicked: (String, FilterType) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = AppTheme.typography.bodyMedium
        )
        FilterComponent(
            listItems = listItems,
            filterType = filterType,
            onFilterItemClicked = onFilterItemClicked
        )
    }
}