package com.napptilus.willywonka.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.napptilus.willywonka.R
import com.napptilus.willywonka.commonsui.compose.components.SingleActionButton

private const val BUTTON_WIDTH = 200

@Composable
fun GenericError(
    title: String,
    description: String,
    onRetryButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = description,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(16.dp))
            SingleActionButton(
                text = stringResource(id = R.string.retry),
                modifier = Modifier
                    .width(BUTTON_WIDTH.dp),
                onClick = { onRetryButtonClicked() }
            )
        }
    }
}