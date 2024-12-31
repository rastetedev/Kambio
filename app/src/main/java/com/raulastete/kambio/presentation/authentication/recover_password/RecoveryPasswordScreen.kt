package com.raulastete.kambio.presentation.authentication.recover_password

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raulastete.kambio.R
import com.raulastete.kambio.presentation.components.KambioPrimaryButton
import com.raulastete.kambio.presentation.components.KambioTextField
import com.raulastete.kambio.presentation.components.KambioTopBar
import com.raulastete.kambio.presentation.components.ScreenBackground
import com.raulastete.kambio.ui.theme.KambioTheme

@Composable
fun RecoveryPasswordScreen(
    // viewModel: RecoveryPasswordViewModel
    navigateBack: () -> Unit
) {
    RecoveryPasswordContent(
        state = RecoveryPasswordUiState(),
        onAction = {
            when (it) {
                RecoveryPasswordAction.NavigateBack -> navigateBack()
                else -> Unit
            }
        }
    )
}

@Composable
fun RecoveryPasswordContent(
    state: RecoveryPasswordUiState,
    onAction: (RecoveryPasswordAction) -> Unit
) {
    ScreenBackground(
        topBar = {
            KambioTopBar(
                navigationIcon = {
                    IconButton(onClick = { onAction(RecoveryPasswordAction.NavigateBack) }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = stringResource(R.string.recovery_password_screen)
            )
        }
    ) {

        Text(stringResource(R.string.recovery_password_header))

        Spacer(Modifier.height(32.dp))

        KambioTextField(
            state = state.email,
            title = stringResource(R.string.email_text_input),
            hint = stringResource(R.string.email_hint)
        )

        Spacer(Modifier.height(32.dp))

        KambioPrimaryButton(
            text = stringResource(R.string.send_email_button),
            isLoading = state.isSendingEmail
        ) {
            onAction(RecoveryPasswordAction.SendEmail)
        }
    }
}

@Preview
@Composable
fun RecoveryPasswordContentPreview() {
    KambioTheme {
        RecoveryPasswordContent(
            state = RecoveryPasswordUiState(),
            onAction = {}
        )
    }
}