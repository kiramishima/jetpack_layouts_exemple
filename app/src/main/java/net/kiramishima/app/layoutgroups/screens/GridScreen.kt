package net.kiramishima.app.layoutgroups.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import net.kiramishima.app.layoutgroups.R
import net.kiramishima.app.layoutgroups.router.BackButtonHandler
import net.kiramishima.app.layoutgroups.router.JetFundamentalsRouter
import net.kiramishima.app.layoutgroups.router.Screen
import kotlin.math.ceil

private val items = listOf(
    Icons.Filled.Check,
    Icons.Filled.Close,
    Icons.Filled.ThumbUp,
    Icons.Filled.Build,
    Icons.Filled.Delete,
    Icons.Filled.Home,
    Icons.Filled.Close,
    Icons.Filled.ThumbUp,
    Icons.Filled.Build,
    Icons.Filled.ThumbUp,
)

data class IconResource(val imageVector: ImageVector, val isVisible: Boolean)

@ExperimentalFoundationApi
@Composable
fun GridScreen() {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        cells = GridCells.Fixed(3),
        content = {
            items(items) { item ->
                GridIcon(IconResource(item, true))
            }
        }
    )

    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun GridView(columnCount: Int) {
    val itemSize = items.size
    val rowCount = ceil(itemSize.toFloat() / columnCount).toInt()
    val gridItems = mutableListOf<List<IconResource>>()
    var position = 0

    for (i in 0 until rowCount) {
        val rowItem = mutableListOf<IconResource>()
        for (j in 0 until columnCount) {
            if (position.inc() <= itemSize) {
                rowItem.add(IconResource(items[position++], true))
            }
        }
        // here
        val itemsToFill = columnCount - rowItem.size

        for (j in 0 until itemsToFill) {
            rowItem.add(IconResource(Icons.Filled.Delete, false))
        }
        gridItems.add(rowItem)
    }
    // here
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(gridItems) { items ->
            RowItem(items)
        }
    }
}

@Composable
fun RowItem(rowItems: List<IconResource>) {
    Row {
        for (element in rowItems)
            GridIcon(element)
    }
}

@Composable
fun RowScope.GridIcon(iconResource: IconResource) {
    val color = if (iconResource.isVisible)
        colorResource(R.color.design_default_color_primary)
    else Color.Transparent

    Icon(
        imageVector = iconResource.imageVector,
        tint = color,
        contentDescription = stringResource(R.string.grid_icon),
        modifier = Modifier
            .size(80.dp, 80.dp)
            .weight(1f)
    )
}

@Composable
fun GridIcon(iconResource: IconResource) {
    val color = if (iconResource.isVisible)
        colorResource(R.color.design_default_color_primary)
    else Color.Transparent

    Icon(
        imageVector = iconResource.imageVector,
        tint = color,
        contentDescription = stringResource(R.string.grid_icon),
        modifier = Modifier
            .size(80.dp, 80.dp)
    )
}