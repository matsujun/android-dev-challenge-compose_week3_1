package com.example.androiddevchallenge

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource


@Composable
fun Home() {
    Surface(color = MaterialTheme.colors.background) {
        Text(text = "Home")
    }
}