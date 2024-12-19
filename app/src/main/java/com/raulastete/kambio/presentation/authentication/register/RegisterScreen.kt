package com.raulastete.kambio.presentation.authentication.register

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raulastete.kambio.R
import com.raulastete.kambio.presentation.components.KambioPasswordTextField
import com.raulastete.kambio.presentation.components.KambioPrimaryButton
import com.raulastete.kambio.presentation.components.KambioTextButton
import com.raulastete.kambio.presentation.components.KambioTextField
import com.raulastete.kambio.presentation.components.KambioTopBar
import com.raulastete.kambio.presentation.components.ScreenBackground

@Composable
fun RegisterScreen(
    //registerViewModel: RegisterViewModel
    navigateBack: () -> Unit,
    navigateToLogin: () -> Unit
) {
    RegisterContent(
        state = RegisterUiState(),
        onAction = {
            when (it) {
                RegisterAction.OnNavigateBack -> navigateBack()
                RegisterAction.OnLoginClick -> navigateToLogin()
                else -> Unit
            }
        }
    )
}

@Composable
fun RegisterContent(
    state: RegisterUiState,
    onAction: (RegisterAction) -> Unit
) {
    ScreenBackground(
        topBar = {
            KambioTopBar(
                navigationIcon = {
                    IconButton(onClick = { onAction(RegisterAction.OnNavigateBack) }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = stringResource(R.string.register_screen)
            )
        }
    ) {
        KambioTextField(
            state = state.email,
            hint = stringResource(R.string.email_hint),
            title = stringResource(R.string.email_text_input),
        )

        Spacer(Modifier.height(32.dp))

        KambioTextField(
            state = state.emailConfirmation,
            hint = stringResource(R.string.email_confirmation_hint),
            title = stringResource(R.string.email_confirmation_text_input),
        )

        Spacer(Modifier.height(32.dp))

        KambioPasswordTextField(
            state = state.password,
            hint = stringResource(R.string.password_hint),
            title = stringResource(R.string.password_register_text_input),
            isPasswordVisible = state.isPasswordVisible,
            onTogglePasswordVisibility = {
                onAction(RegisterAction.OnTogglePasswordVisibility)
            }
        )

        Spacer(Modifier.height(32.dp))

        KambioPasswordTextField(
            state = state.passwordConfirmation,
            hint = stringResource(R.string.password_confirmation_hint),
            title = stringResource(R.string.password_confirmation_text_input),
            isPasswordVisible = state.isPasswordVisible,
            onTogglePasswordVisibility = {
                onAction(RegisterAction.OnTogglePasswordConfirmationVisibility)
            }
        )

        Spacer(Modifier.height(32.dp))

        KambioPrimaryButton(
            text = stringResource(R.string.register_button),
            isLoading = state.isRegistering
        ) {
            onAction(RegisterAction.OnRegisterClick)
        }

        Spacer(Modifier.height(8.dp))

        KambioTextButton(
            text = stringResource(R.string.login_text_button)
        ) {
            onAction(RegisterAction.OnLoginClick)
        }
    }
}

@Preview
@Composable
fun RegisterContentPreview() {
    RegisterContent(
        state = RegisterUiState(),
        onAction = {}
    )
}