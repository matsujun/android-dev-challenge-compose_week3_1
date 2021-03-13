package com.example.androiddevchallenge

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.chrisbanes.accompanist.insets.statusBarsPadding


@Composable
fun Profile() {
    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize().statusBarsPadding()) {
        Text(
            text = "Profile",
        )
    }
}