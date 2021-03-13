package com.example.androiddevchallenge

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Plant
import com.example.androiddevchallenge.data.plants
import com.example.androiddevchallenge.data.themes
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography
import com.skydoves.landscapist.glide.GlideImage
import dev.chrisbanes.accompanist.insets.navigationBarsPadding


@Composable
fun Home() {

    var searchText by remember { mutableStateOf("") }

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp)
            .navigationBarsPadding()
    ) {
        Column(
            Modifier
                .fillMaxSize()
        ) {
            Spacer(Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onBackground,
                        shape = RoundedCornerShape(4.dp)
                    )
            ) {
                val searchLabel = stringResource(R.string.home_search)
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = searchText,
                    onValueChange = { searchText = it },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = MyOutlinedTextColors(),
                    placeholder = {
                        Text(
                            text = searchLabel,
                            style = typography.body1,
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = searchLabel,
                            modifier = Modifier.size(18.dp),
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                )
            }
            Text(
                text = stringResource(id = R.string.home_themes),
                style = typography.h1,
                modifier = Modifier
                    .paddingFromBaseline(top = 32.dp, bottom = 16.dp)
                    .padding(start = 16.dp)
            )
            Themes()

            Row(
                modifier = Modifier
                    .paddingFromBaseline(top = 32.dp, bottom = 16.dp)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.home_garden),
                    style = typography.h1,
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.FilterList,
                        contentDescription = "filter",
                        modifier = Modifier.size(24.dp),
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
            Plants()
        }

    }
}

@Composable
fun Themes() {
    LazyRow {
        itemsIndexed(items = themes) { index, theme ->
            if (index == 0) {
                Spacer(modifier = Modifier.width(16.dp))
            } else {
                Spacer(modifier = Modifier.width(8.dp))
            }
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
            // for final item
            if (index == themes.size - 1) {
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}

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
            Row (
                verticalAlignment = Alignment.Bottom
                    ){
                Column(
                    modifier = Modifier
                        .weight(1f)
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
                            .paddingFromBaseline(top = 16.dp, bottom = 24.dp),
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


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewHome() {
    MyTheme {
        Home()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewHome() {
    MyTheme(darkTheme = true) {
        Home()
    }
}