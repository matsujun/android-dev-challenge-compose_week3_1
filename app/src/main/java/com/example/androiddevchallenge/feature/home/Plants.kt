/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Plant
import com.example.androiddevchallenge.data.plants
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun Plants() {
    LazyColumn {
        itemsIndexed(items = plants) { index, plant ->
            if (index != 0) {
                Spacer(modifier = Modifier.height(8.dp))
            }
            Plant(plant)
            // for final item
            if (index == plants.size - 1) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun Plant(plant: Plant) {
    var checked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        GlideImage(
            imageModel = plant.imageUrl,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(4.dp)),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,

        )
        Box(
            modifier = Modifier.weight(1f).height(64.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = plant.name,
                        style = typography.h2,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .paddingFromBaseline(top = 24.dp),
                    )
                    Text(
                        text = plant.description,
                        style = typography.body1,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .paddingFromBaseline(bottom = 24.dp),
                    )
                }
                Checkbox(
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .size(24.dp),
                    checked = checked,
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = MaterialTheme.colors.onSecondary
                    ),
                    onCheckedChange = { checked = it }
                )
            }
            Divider(
                Modifier.padding(start = 8.dp)

            )
        }
    }
}

@Preview
@Composable
fun PreviewPlant() {
    MyTheme {
        Plant(plants[0])
    }
}
