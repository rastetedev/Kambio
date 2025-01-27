package com.raulastete.kambio.presentation.home

import androidx.compose.animation.AnimatedVisibility
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
import com.raulastete.kambio.domain.entity.ExchangeType
import com.raulastete.kambio.presentation.components.KambioPrimaryButton
import com.raulastete.kambio.presentation.components.KambioTextButton
import com.raulastete.kambio.presentation.components.KambioTextFieldWithButton
import com.raulastete.kambio.presentation.components.ScreenBackground
import com.raulastete.kambio.presentation.home.components.CurrencyAmountInput
import com.raulastete.kambio.presentation.home.components.CurrencyAmountInputModel
import com.raulastete.kambio.presentation.home.components.ExchangeRateButton
import com.raulastete.kambio.ui.theme.KambioTheme
import org.koin.compose.viewmodel.koinViewModel
import java.util.Locale

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel(),
) {
    val state = homeViewModel.state
    HomeContent(
        state = state,
        onAction = homeViewModel::onAction
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
                label = stringResource(R.string.buying_label),
                amount = "3.729",
                isSelected = state.exchangeType.isBuy()
            ) {
                onAction(HomeAction.ChangeExchangeType)
            }

            Spacer(Modifier.width(32.dp))

            ExchangeRateButton(
                label = stringResource(R.string.selling_label),
                amount = "3.729",
                isSelected = state.exchangeType.isSell()
            ) {
                onAction(HomeAction.ChangeExchangeType)
            }
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
                "${state.exchangeType.savingEstimationCurrency.symbol} ${String.format(Locale.getDefault(), "%.2f", state.savingAmount)}",
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
                    currency = state.exchangeType.originCurrency,
                    amount = state.originAmount,
                    title = stringResource(R.string.send_currency_amount_input_label)
                ),
                onValueChange = {
                    onAction(HomeAction.UpdateOriginAmount(it))
                }
            )

            CurrencyAmountInput(
                modifier = Modifier.constrainAs(bottomCurrencyAmountInput) {
                    top.linkTo(topCurrencyAmountInput.bottom, 8.dp)
                    start.linkTo(topCurrencyAmountInput.start)
                    end.linkTo(topCurrencyAmountInput.end)
                },
                model = CurrencyAmountInputModel(
                    currency = state.exchangeType.destinationCurrency,
                    amount = state.destinationAmount,
                    title = stringResource(R.string.receive_currency_amount_input_label),
                ),
                onValueChange = {
                    onAction(HomeAction.UpdateDestinationAmount(it))
                }
            )

            SwitchExchangeButton(
                exchangeType = state.exchangeType,
                modifier = Modifier.constrainAs(switchExchangeTypeButton) {
                    top.linkTo(topCurrencyAmountInput.top)
                    bottom.linkTo(bottomCurrencyAmountInput.bottom)
                    end.linkTo(parent.end, margin = 24.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                }
            ) {
                onAction(HomeAction.ChangeExchangeType)
            }

        }

        Spacer(Modifier.height(8.dp))

        KambioTextButton(text = stringResource(R.string.insert_discount_code_text_button)) {
            onAction(HomeAction.ShowCouponCode)
        }

        Spacer(Modifier.height(8.dp))

        AnimatedVisibility(visible = state.showCouponCodeInput) {
            KambioTextFieldWithButton(
                state = TextFieldState(),
                buttonText = stringResource(R.string.apply_code_button),
                isLoading = false,
                title = stringResource(R.string.insert_code_header),
                hint = null
            ) {
                onAction(HomeAction.SendCouponCode)
            }
        }

        Spacer(Modifier.weight(1f))

        KambioPrimaryButton(
            text = stringResource(R.string.start_operation_button),
            isLoading = false
        ) {
            onAction(HomeAction.StartOperation)
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
        if (exchangeType.isSell()) 0f else 360f,
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
    KambioTheme {
        HomeContent(
            state = HomeUiState(),
            onAction = {}
        )
    }
}