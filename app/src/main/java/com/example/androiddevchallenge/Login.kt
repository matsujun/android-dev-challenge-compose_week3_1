package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.navigate


@Composable
fun Login(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Text(text = "Login")
            Button(onClick = {
                navController.navigate("home") }) {
                Text(text = stringResource(R.string.login_login))
            }
        }
    }
}