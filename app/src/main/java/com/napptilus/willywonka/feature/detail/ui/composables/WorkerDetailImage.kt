package com.napptilus.willywonka.feature.detail.ui.composables

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

private const val IMAGE_RATIO_WIDTH = 100
private const val IMAGE_RATIO_HEIGHT = 72

@Composable
fun WorkerDetailImage(imageUrl: String) {
    val imageWidth = LocalConfiguration.current.screenWidthDp.dp
    val imageHeight = (imageWidth * IMAGE_RATIO_WIDTH / IMAGE_RATIO_HEIGHT) / 2

    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = Modifier
            .size(
                width = imageWidth,
                height = imageHeight
            ),
        contentScale = ContentScale.Crop,
    )
}