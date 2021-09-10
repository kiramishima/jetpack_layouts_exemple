package net.kiramishima.app.layoutgroups.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import net.kiramishima.app.layoutgroups.R
import net.kiramishima.app.layoutgroups.router.BackButtonHandler
import net.kiramishima.app.layoutgroups.router.JetFundamentalsRouter
import net.kiramishima.app.layoutgroups.router.Screen

@Composable
fun ProgressIndicatorScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            color = colorResource(id = R.color.design_default_color_primary),
            strokeWidth = 5.dp
        )
        LinearProgressIndicator(progress = 0.5f)
    }
    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}