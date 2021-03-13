package com.example.androiddevchallenge

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography


@Composable
fun Login(navController: NavController? = null) {

    var textMail by remember { mutableStateOf("") }
    var textPassword by remember { mutableStateOf("") }

    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.login_title),
                modifier = Modifier.paddingFromBaseline(top = 184.dp, bottom = 16.dp),
                style = typography.h1,
            )
            OutlinedTextField(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                value = textMail,
                onValueChange = { textMail = it },
                colors = MyOutlinedTextColors(),
                label = {
                    Text(
                        text = stringResource(R.string.login_mail_hint),
                        style = typography.body1,
                    )
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                value = textPassword,
                onValueChange = { textPassword = it },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = MyOutlinedTextColors(),
                label = {
                    Text(
                        text = stringResource(R.string.login_pass_hint),
                        style = typography.body1,
                    )
                }
            )
            LinkClickableText(
                wholeStringResId = R.string.login_policy_notice,
                listOf(
                    R.string.login_policy_notice_link1 to "https://www.google.com",
                    R.string.login_policy_notice_link2 to "https://www.yahoo.com"
                ),
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp)
            )

            ExtendedFloatingActionButton(
                onClick = {
                    navController?.navigate("home")
                },
                text = {
                    Text(
                        text = stringResource(R.string.login_login),
                        style = typography.button,
                        color = MaterialTheme.colors.onSecondary
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp)
            )
        }
    }
}

@Composable
fun MyOutlinedTextColors(): TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
    cursorColor = MaterialTheme.colors.secondary,
    focusedBorderColor = MaterialTheme.colors.secondary,
    focusedLabelColor = MaterialTheme.colors.secondary,
    placeholderColor = MaterialTheme.colors.onBackground,
    unfocusedLabelColor = MaterialTheme.colors.onBackground,
    unfocusedBorderColor = MaterialTheme.colors.onBackground,
)

@Composable
fun LinkClickableText(
    wholeStringResId: Int,
    links: List<Pair<Int, String>>,
    modifier: Modifier
) {

    val notice1 = buildAnnotatedString {
        val str = stringResource(wholeStringResId)
        append(str)
        links.forEach { (linkStringResId, url) ->
            val linkText = stringResource(linkStringResId)
            val startIndex = str.indexOf(linkText)
            val endIndex = startIndex + linkText.length
            addStyle(
                style = SpanStyle(textDecoration = TextDecoration.Underline),
                start = startIndex,
                end = endIndex
            )
            addStringAnnotation(
                tag = "$linkStringResId:$url",
                annotation = url,
                start = startIndex,
                end = endIndex
            )
        }
    }
    ClickableText(
        text = notice1,
        style = typography.body2.copy(
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onBackground
        ),
        modifier = modifier,
        onClick = {
            links.forEach { (linkStringResId, url) ->
                notice1.getStringAnnotations("$linkStringResId:$url", it, it).firstOrNull()
                    ?.let { annotation ->
                        Log.d("MJ", "Open ${annotation.item}")
                    }
            }
        }
    )
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewLogin() {
    MyTheme {
        Login()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewLogin() {
    MyTheme(darkTheme = true) {
        Login()
    }
}