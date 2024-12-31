package com.raulastete.kambio.presentation.authentication.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raulastete.kambio.R
import com.raulastete.kambio.presentation.components.KambioPasswordTextField
import com.raulastete.kambio.presentation.components.KambioPrimaryButton
import com.raulastete.kambio.presentation.components.KambioTextButton
import com.raulastete.kambio.presentation.components.KambioTextField
import com.raulastete.kambio.presentation.components.ScreenBackground
import com.raulastete.kambio.ui.theme.KambioTheme

@Composable
fun LoginScreen(
    navigateToRecoverPassword: () -> Unit,
    navigateToRegister: () -> Unit,
    navigateToHome: () -> Unit
) {
    LoginContent(
        state = LoginState(),
        onAction = {
            when (it) {
                LoginAction.RecoverPasswordClick -> navigateToRecoverPassword()
                LoginAction.RegisterClick -> navigateToRegister()
                else -> navigateToHome()
            }
        }
    )
}

@Composable
fun LoginContent(
    state: LoginState,
    onAction: (LoginAction) -> Unit
) {

    ScreenBackground(modifier = Modifier.padding(top = 16.dp)) {

        Image(
            painter = painterResource(R.drawable.kambio_standalone),
            modifier = Modifier.size(100.dp),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
        )

        Spacer(Modifier.height(48.dp))

        Text(
            text = stringResource(R.string.login),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(Modifier.height(32.dp))

        KambioTextField(
            state = state.email,
            hint = stringResource(R.string.email_hint),
            title = stringResource(R.string.email_text_input),
        )

        Spacer(Modifier.height(32.dp))

        KambioPasswordTextField(
            state = state.password,
            isPasswordVisible = state.isPasswordVisible,
            hint = stringResource(R.string.password_hint),
            title = stringResource(R.string.password_text_input),
            onTogglePasswordVisibility = { onAction(LoginAction.TogglePasswordVisibility) }
        )

        Spacer(Modifier.height(16.dp))

        KambioTextButton(
            text = stringResource(R.string.forgot_password_text_button)
        ) { onAction(LoginAction.RecoverPasswordClick) }


        Spacer(Modifier.weight(1f))

        KambioPrimaryButton(
            text = stringResource(R.string.login_button),
            isLoading = state.isLoggingIn,
        ) {
            onAction(LoginAction.LoginClick)
        }

        Spacer(Modifier.height(8.dp))

        KambioTextButton(
            text = stringResource(R.string.register_text_button)
        ) {
            onAction(LoginAction.RegisterClick)
        }
    }
}

@Preview
@Composable
private fun LoginContentPreview() {
    KambioTheme {
        LoginContent(
            state = LoginState(),
            onAction = {}
        )
    }
}