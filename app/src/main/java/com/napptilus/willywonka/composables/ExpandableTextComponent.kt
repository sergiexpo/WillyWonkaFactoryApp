package com.napptilus.willywonka.composables

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.napptilus.willywonka.R
import com.napptilus.willywonka.commonsui.compose.components.ExpandableText
import com.napptilus.willywonka.commonsui.compose.theme.providers.AppTheme

@Composable
fun ExpandableTextComponent(
    title: String,
    text: String
) {
    Text(
        text = title,
        modifier = Modifier.height(24.dp),
        style = AppTheme.typography.bodySmall
    )
    ExpandableText(
        text = text,
        seeMoreText = stringResource(id = R.string.see_more),
        seeLessText = stringResource(id = R.string.see_less), )
}