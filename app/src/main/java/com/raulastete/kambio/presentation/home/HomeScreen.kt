package com.raulastete.kambio.presentation.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChangeCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.raulastete.kambio.R
import com.raulastete.kambio.domain.entity.Currency
import com.raulastete.kambio.domain.entity.CurrencyAmount
import com.raulastete.kambio.domain.entity.ExchangeType
import com.raulastete.kambio.presentation.components.KambioPrimaryButton
import com.raulastete.kambio.presentation.components.KambioTextButton
import com.raulastete.kambio.presentation.components.KambioTextFieldWithButton
import com.raulastete.kambio.presentation.components.ScreenBackground
import com.raulastete.kambio.presentation.home.components.CurrencyAmountInput
import com.raulastete.kambio.presentation.home.components.CurrencyAmountInputModel
import com.raulastete.kambio.presentation.home.components.ExchangeRateButton
import java.math.BigDecimal

@Composable
fun HomeScreen(

) {
    HomeContent(
        state = HomeUiState(),
        onAction = {

        }
    )
}

@Composable
fun HomeContent(
    state: HomeUiState,
    onAction: (HomeAction) -> Unit
) {

    ScreenBackground {

        Row {
            ExchangeRateButton(
                label = "Compra",
                amount = "3.729",
                isSelected = true
            ) { }

            Spacer(Modifier.width(32.dp))

            ExchangeRateButton(
                label = "Venta",
                amount = "3.729",
                isSelected = false
            ) { }
        }

        Spacer(Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                stringResource(R.string.saving_estimation_header),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                state.savingEstimation,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(Modifier.height(16.dp))

        ConstraintLayout {

            val (topCurrencyAmountInput, bottomCurrencyAmountInput, switchExchangeTypeButton) = createRefs()

            CurrencyAmountInput(
                modifier = Modifier.constrainAs(topCurrencyAmountInput) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                model = CurrencyAmountInputModel(
                    currencyAmount = CurrencyAmount(
                        currency = Currency.Dollar,
                        amount = BigDecimal.valueOf(300)
                    ),
                    title = "¿Cuánto envías?"
                )
            )

            CurrencyAmountInput(
                modifier = Modifier.constrainAs(bottomCurrencyAmountInput) {
                    top.linkTo(topCurrencyAmountInput.bottom, 8.dp)
                    start.linkTo(topCurrencyAmountInput.start)
                    end.linkTo(topCurrencyAmountInput.end)
                },
                model = CurrencyAmountInputModel(
                    currencyAmount = CurrencyAmount(
                        currency = Currency.PeruvianSol,
                        amount = BigDecimal.valueOf(300)
                    ),
                    title = "Entonces recibes"
                )
            )

            SwitchExchangeButton(
                exchangeType = ExchangeType.BUY,
                modifier = Modifier.constrainAs(switchExchangeTypeButton) {
                    top.linkTo(topCurrencyAmountInput.top)
                    bottom.linkTo(bottomCurrencyAmountInput.bottom)
                    end.linkTo(parent.end, margin = 24.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                }
            ) {

            }

        }

        Spacer(Modifier.height(8.dp))

        KambioTextButton(text = stringResource(R.string.insert_discount_code_text_button)) { }

        Spacer(Modifier.height(8.dp))

        KambioTextFieldWithButton(
            state = TextFieldState(),
            buttonText = stringResource(R.string.apply_code_button),
            isLoading = false,
            title = stringResource(R.string.insert_code_header),
            hint = null
        ) { }

        Spacer(Modifier.weight(1f))

        KambioPrimaryButton(
            text = stringResource(R.string.start_operation_button),
            isLoading = false
        ) {

        }
    }
}

@Composable
private fun SwitchExchangeButton(
    exchangeType: ExchangeType,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    val buttonIconDegrees by animateFloatAsState(
        if (exchangeType.isBuy) 0f else 360f,
        animationSpec = tween(500)
    )

    Box(
        modifier
            .size(48.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .size(36.dp)
                .background(
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = CircleShape
                )
        )
        Icon(
            imageVector = Icons.Default.ChangeCircle,
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .rotate(buttonIconDegrees),
            tint = MaterialTheme.colorScheme.primary
        )
    }


}


@Preview
@Composable
fun HomeContentPreview() {
    HomeContent(
        state = HomeUiState(),
        onAction = {}
    )
}