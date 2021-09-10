package net.kiramishima.app.layoutgroups.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import net.kiramishima.app.layoutgroups.router.JetFundamentalsRouter
import net.kiramishima.app.layoutgroups.router.Screen
import net.kiramishima.app.layoutgroups.screens.*

@ExperimentalFoundationApi
@Composable
fun JetFundamentalsApp() {
    Surface(color = MaterialTheme.colors.background) {
        Crossfade(targetState = JetFundamentalsRouter.currentScreen) { screenState ->
            when (screenState.value) {
                is Screen.Navigation -> NavigationScreen()
                is Screen.Text -> TextScreen()
                is Screen.TextField -> TextFieldScreen()
                is Screen.Buttons -> ExploreButtonsScreen()
                is Screen.ProgressIndicator -> ProgressIndicatorScreen()
                is Screen.AlertDialog -> AlertDialogScreen()
                is Screen.Row -> RowScreen()
                is Screen.Column -> ColumnScreen()
                is Screen.Box -> BoxScreen()
                is Screen.Surface -> SurfaceScreen()
                is Screen.Scaffold -> ScaffoldScreen()
                is Screen.Scrolling -> ScrollingScreen()
                is Screen.List -> ListScreen()
                is Screen.Grid -> GridScreen()
            }
        }
    }
}