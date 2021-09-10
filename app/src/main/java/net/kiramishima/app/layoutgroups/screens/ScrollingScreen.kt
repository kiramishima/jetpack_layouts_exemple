package net.kiramishima.app.layoutgroups.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import net.kiramishima.app.layoutgroups.R
import net.kiramishima.app.layoutgroups.router.BackButtonHandler
import net.kiramishima.app.layoutgroups.router.JetFundamentalsRouter
import net.kiramishima.app.layoutgroups.router.Screen

@Composable
fun ScrollingScreen() {
    MyScrollingScreen()

    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyScrollingScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState()) /* modifier = modifier.horizontalScroll(rememberScrollState()) */) {
        BookImage(imageResId = R.drawable.advanced_architecture_android, R.string.advanced_architecture_android )
        BookImage(R.drawable.kotlin_aprentice, contentDescriptionResId = R.string.kotlin_apprentice)
        BookImage(R.drawable.kotlin_coroutines, R.string.kotlin_coroutines)
    }
}

@Composable
fun BookImage(@DrawableRes imageResId: Int, @StringRes contentDescriptionResId: Int) {
    Image(
        bitmap = ImageBitmap.imageResource(imageResId),
        contentDescription = stringResource(contentDescriptionResId),
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.size(476.dp, 616.dp)
    )
}