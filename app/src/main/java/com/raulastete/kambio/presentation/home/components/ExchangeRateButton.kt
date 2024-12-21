package com.raulastete.kambio.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ExchangeRateButton(
    modifier: Modifier = Modifier,
    label: String,
    amount: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    InputChip(
        modifier = modifier,
        selected = isSelected,
        onClick = onClick,
        colors = InputChipDefaults.inputChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
            labelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            containerColor = MaterialTheme.colorScheme.surface
        ),
        label = {
            Row(
                modifier = Modifier.padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.displayMedium,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = amount,
                    style = MaterialTheme.typography.displayMedium,
                )
            }
        },
    )
}