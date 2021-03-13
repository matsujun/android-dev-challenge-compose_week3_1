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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Theme
import com.example.androiddevchallenge.data.themes
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun Themes() {
    LazyRow {
        itemsIndexed(items = themes) { index, theme ->
            if (index == 0) {
                Spacer(modifier = Modifier.width(16.dp))
            } else {
                Spacer(modifier = Modifier.width(8.dp))
            }
            Theme(theme)
            // for final item
            if (index == themes.size - 1) {
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}

@Composable
fun Theme(theme: Theme) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(bottom = 8.dp),
        elevation = 1.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.wrapContentSize()
        ) {
            GlideImage(
                imageModel = theme.imageUrl,
                modifier = Modifier
                    .width(136.dp)
                    .height(96.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
            Text(
                text = theme.name,
                style = typography.h2,
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
                    .padding(start = 16.dp),
            )
        }
    }
}

@Preview
@Composable
fun PreviewTheme() {
    MyTheme {
        Theme(themes[0])
    }
}
