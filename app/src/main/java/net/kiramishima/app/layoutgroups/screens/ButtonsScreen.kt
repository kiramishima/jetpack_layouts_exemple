package net.kiramishima.app.layoutgroups.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.kiramishima.app.layoutgroups.R
import net.kiramishima.app.layoutgroups.router.BackButtonHandler
import net.kiramishima.app.layoutgroups.router.JetFundamentalsRouter
import net.kiramishima.app.layoutgroups.router.Screen

@Composable
fun ExploreButtonsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyButton()
        MyRadioGroup()
        MyFloatingActionButton()
        BackButtonHandler {
            JetFundamentalsRouter.navigateTo(Screen.Navigation)
        }
    }
}
@Composable
@Preview
fun MyButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.design_default_color_primary)),
        border = BorderStroke(1.dp, color = colorResource(id = R.color.design_default_color_primary_dark))
    ) {
       Text(text = stringResource(id = R.string.button_text), color = Color.White)
    }
}

@Composable
@Preview
fun MyRadioGroup() {
    val radioButtons = listOf(0, 1, 2) // 1

    val selectedButton = remember {
        mutableStateOf(radioButtons.first())
    } // 2

    Column {
        radioButtons.forEach { index -> // 3
            val isSelected = index == selectedButton.value
            val colors = RadioButtonDefaults.colors(selectedColor = colorResource(id = R.color.design_default_color_primary),
                unselectedColor = colorResource(id = R.color.design_default_color_primary_dark), disabledColor = Color.LightGray
            )

            RadioButton( // 5
                colors = colors,
                selected = isSelected,
                onClick = { selectedButton.value = index } // 6
            )
        }
    }
}
@Composable
@Preview
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        backgroundColor = colorResource(id = R.color.design_default_color_primary),
        contentColor = Color.White,
        content = {
            Icon(Icons.Filled.Favorite, contentDescription = "Test FAB")
        }
    )
}