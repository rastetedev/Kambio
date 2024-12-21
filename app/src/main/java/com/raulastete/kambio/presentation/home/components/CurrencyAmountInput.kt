package com.raulastete.kambio.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.raulastete.kambio.R
import com.raulastete.kambio.domain.entity.Currency
import com.raulastete.kambio.domain.entity.CurrencyAmount

@Composable
fun CurrencyAmountInput(
    modifier: Modifier = Modifier,
    model: CurrencyAmountInputModel
) {

    var isFocus: Boolean by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = if(isFocus) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                shape = RoundedCornerShape(8.dp)
            )

    ) {
        Column(
            modifier = Modifier
                .weight(7f)
                .padding(12.dp)
                .padding(vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = model.title,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = model.currencyAmount.currency.symbol,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                BasicTextField(
                    modifier = Modifier.onFocusChanged {
                        isFocus = it.isFocused
                    },
                    state = TextFieldState(),
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
                    textStyle = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onBackground)
                )
            }
        }

        Row(
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.aligned(Alignment.End),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = model.currencyLabel,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(Modifier.width(4.dp))

            Image(
                painter = model.currencyIcon,
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentDescription = null
            )
            Spacer(Modifier.width(16.dp))
        }
    }
}

data class CurrencyAmountInputModel(
    val currencyAmount: CurrencyAmount,
    val title: String

) {
    val currencyLabel: String
        @Composable get() = when (currencyAmount.currency) {
            Currency.Dollar -> stringResource(R.string.dollar_label)
            Currency.PeruvianSol -> stringResource(R.string.peruvian_sol_label)
        }

    val currencyIcon: Painter
        @Composable get() = when (currencyAmount.currency) {
            Currency.Dollar -> painterResource(R.drawable.eeuu_icon)
            Currency.PeruvianSol -> painterResource(R.drawable.peru_icon)
        }
}