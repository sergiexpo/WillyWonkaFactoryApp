package com.napptilus.willywonka.feature.home.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.napptilus.willywonka.feature.home.ui.models.WorkerUI
import com.napptilus.willywonka.utils.getGenderText

@Composable
fun WorkerItem(
    item: WorkerUI,
    onItemClicked: (Int?) -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            )
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(
            modifier = Modifier.clickable { onItemClicked(item.id) }
        ) {
            WorkerItemImage(imageUrl = item.image)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = item.first_name)
                Text(text = item.profession)
                Text(text = item.email)
                Text(text = stringResource(id = item.gender.getGenderText()))
                Text(text = item.country)
            }
        }
    }
}
