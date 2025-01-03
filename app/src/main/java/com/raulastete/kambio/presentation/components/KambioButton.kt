package com.raulastete.kambio.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun KambioPrimaryButton(
    text: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .height(IntrinsicSize.Min)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(15.dp)
                    .alpha(if (isLoading) 1f else 0f),
                strokeWidth = 1.5.dp,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = text,
                modifier = Modifier
                    .alpha(if (isLoading) 0f else 1f),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun KambioElevatedButton(
    modifier: Modifier = Modifier,
    text: String,
    isLoading: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable { onClick() }
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(15.dp)
                .alpha(if (isLoading) 1f else 0f),
            strokeWidth = 1.5.dp,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            text = text,
            modifier = Modifier
                .alpha(if (isLoading) 0f else 1f),
            style = MaterialTheme.typography.displaySmall
        )
    }

}

@Composable
fun KambioTextButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled
    ) {
        Text(
            text = text,
            textDecoration = TextDecoration.Underline,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}