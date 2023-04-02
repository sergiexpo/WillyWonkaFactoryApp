package com.napptilus.willywonka.commonsui.compose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.napptilus.willywonka.commonsui.compose.theme.providers.AppTheme

private const val MAX_LINES_VALUE = 3

@Composable
fun ExpandableText(
    text: String,
    seeMoreText: String,
    seeLessText: String,
) {
    var isDescriptionExpanded by remember { mutableStateOf(false) }
    var isExpandedNeeded by remember { mutableStateOf(false) }

    Text(
        text = text,
        style = AppTheme.typography.bodyLarge,
        textAlign = TextAlign.Justify,
        onTextLayout = { textLayoutResult ->
            isExpandedNeeded = textLayoutResult.hasVisualOverflow
        },
        maxLines = if (isDescriptionExpanded) Int.MAX_VALUE else MAX_LINES_VALUE,
        overflow = if (isDescriptionExpanded) TextOverflow.Visible else TextOverflow.Ellipsis
    )
    if (isExpandedNeeded || isDescriptionExpanded) {
        Text(
            text = if (isDescriptionExpanded) seeLessText else seeMoreText,
            modifier = Modifier
                .clickable(
                    enabled = true,
                    onClick = { isDescriptionExpanded = !isDescriptionExpanded }
                )
                .padding(top = 8.dp),
            style = AppTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}