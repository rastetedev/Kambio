package com.raulastete.kambio.presentation.transaction.validation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.raulastete.kambio.R
import com.raulastete.kambio.presentation.components.KambioPrimaryButton
import com.raulastete.kambio.presentation.components.KambioTextButton
import com.raulastete.kambio.presentation.components.KambioTextField
import com.raulastete.kambio.presentation.components.KambioTopBar
import com.raulastete.kambio.presentation.components.ScreenBackground
import com.raulastete.kambio.presentation.transaction.components.Step
import com.raulastete.kambio.presentation.transaction.components.StepLine

@Composable
fun ValidationScreen(
    navigateBack: () -> Unit
) {
    ValidationContent(
        onAction = {

        }
    )
}

@Composable
fun ValidationContent(
    onAction: (ValidationAction) -> Unit
) {

    ScreenBackground(
        topBar = {
            KambioTopBar(
                navigationIcon = {
                    IconButton(onClick = { onAction(ValidationAction.NavigateBack) }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = stringResource(R.string.transaction_validation_screen)
            )
        }
    ) {

        StepLine(
            activeStep = Step.VALIDATION
        )

        Spacer(Modifier.height(32.dp))

        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant,
            shape = RoundedCornerShape(8.dp),
            tonalElevation = 8.dp,
            shadowElevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Text(stringResource(R.string.operation_code_header))

                KambioTextField(
                    state = TextFieldState(),
                    hint = stringResource(R.string.operation_code_hint),
                    title = null
                )

                Text(stringResource(R.string.operation_code_footer))
            }
        }

        Spacer(Modifier.weight(1f))

        KambioTextButton(
            text = stringResource(R.string.operation_detail_text_button)
        ) { }

        Spacer(Modifier.height(16.dp))

        KambioPrimaryButton(
            text = stringResource(R.string.send_operation_code_button),
            isLoading = false
        ) { }
    }
}