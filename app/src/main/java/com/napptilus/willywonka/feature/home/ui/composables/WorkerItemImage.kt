package com.napptilus.willywonka.feature.home.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

private const val IMAGE_WIDTH = 120
private const val IMAGE_HEIGHT = 120

@Composable
fun WorkerItemImage(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = Modifier
            .padding(all = 8.dp)
            .size(
                width = IMAGE_WIDTH.dp,
                height = IMAGE_HEIGHT.dp)
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop,
    )
}