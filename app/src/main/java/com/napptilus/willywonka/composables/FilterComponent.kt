package com.napptilus.willywonka.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.napptilus.willywonka.utils.FilterType
import com.napptilus.willywonka.utils.getGenderText

@Composable
fun FilterComponent(
    listItems: MutableList<String>,
    filterType: FilterType,
    onFilterItemClicked: (String, FilterType) -> Unit
) {
    var isExpandedNeeded by remember { mutableStateOf(false) }
    Box(
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = { isExpandedNeeded = true })
        {
            Icon(
                imageVector = Icons.Default.FilterList,
                contentDescription = "null"
            )
        }
        DropdownMenu(
            expanded = isExpandedNeeded,
            onDismissRequest = { isExpandedNeeded = false }
        ) {
            listItems.forEachIndexed { _, itemValue ->
                DropdownMenuItem(
                    text = {
                        val textToShow =
                            if (filterType == FilterType.GENDER) stringResource(id = itemValue.getGenderText())
                            else itemValue
                        Text(text = textToShow)
                    },
                    onClick = {
                        onFilterItemClicked(itemValue, filterType)
                        isExpandedNeeded = false
                    }
                )
            }
        }
    }
}