package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.typography
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun Welcome(navController: NavController? = null) {
    Surface(color = colors.primary, modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.welcome_bg),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.BottomCenter
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(72.dp))
            Image(
                painter = painterResource(id = R.drawable.welcome_illos),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 310.dp, height = 280.dp)
                    .offset(88.dp)
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(48.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,

                )
            Text(
                text = stringResource(id = R.string.welcome_subtitle),
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 40.dp),
                style = typography.subtitle1,
            )
            ExtendedFloatingActionButton(
                onClick = {

                },
                text = {
                    Text(
                        text = stringResource(R.string.welcome_create_account),
                        style = typography.button,
                        color = colors.onSecondary
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .height(48.dp),
                elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp)
            )
            TextButton(
                onClick = { navController?.navigate("login") },
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp),
            ) {
                Text(
                    text = stringResource(R.string.welcome_login),
                    style = typography.button,
                    color = if (colors.isLight) {
                        pink900
                    } else {
                        white
                    }
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewWelcome() {
    MyTheme {
        Welcome()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewWelcome() {
    MyTheme(darkTheme = true) {
        Welcome()
    }
}
