package com.raulastete.kambio.presentation.components

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raulastete.kambio.ui.theme.KambioTheme

@Composable
fun ScreenBackground(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit,
) {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val screenWidthPx = with(density) {
        configuration.screenWidthDp.dp.roundToPx()
    }
    val smallDimension = minOf(
        configuration.screenWidthDp.dp,
        configuration.screenHeightDp.dp
    )
    val smallDimensionPx = with(density) {
        smallDimension.roundToPx()
    }
    val primaryColor = MaterialTheme.colorScheme.primary
    val isAtLeastAndroid12 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    Scaffold(
        topBar = topBar
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            if(isSystemInDarkTheme()){
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .then(
                            if (isAtLeastAndroid12) {
                                Modifier.blur(smallDimension / 3f)
                            } else Modifier
                        )
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    if (isAtLeastAndroid12) primaryColor else primaryColor.copy(
                                        alpha = 0.3f
                                    ),
                                    MaterialTheme.colorScheme.background
                                ),
                                center = Offset(
                                    x = screenWidthPx / 2f,
                                    y = -100f
                                ),
                                radius = smallDimensionPx / 2f
                            )
                        )
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
                    .then(modifier),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                content()
            }
        }
    }
}

@Preview
@Composable
private fun ScreenBackgroundPreview() {
    KambioTheme {
        ScreenBackground(
            modifier = Modifier.fillMaxSize()
        ) {
        }
    }
}
