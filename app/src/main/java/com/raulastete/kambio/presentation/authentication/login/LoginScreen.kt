package com.raulastete.kambio.presentation.authentication.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.raulastete.kambio.R
import com.raulastete.kambio.presentation.components.GradientBackground
import com.raulastete.kambio.presentation.components.KambioPrimaryButton
import com.raulastete.kambio.presentation.components.KambioPasswordTextField
import com.raulastete.kambio.presentation.components.KambioTextButton
import com.raulastete.kambio.presentation.components.KambioTextField

@Composable
fun LoginScreen() {
    LoginContent(
        state = LoginState()
    ) { }
}

@Composable
fun LoginContent(
    state: LoginState,
    onAction: (LoginAction) -> Unit
) {

    GradientBackground {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
                .padding(vertical = 32.dp)
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(Modifier.height(32.dp))

            Image(
                painter = painterResource(R.drawable.kambio_standalone),
                modifier = Modifier.size(100.dp),
                contentDescription = null
            )

            Spacer(Modifier.height(48.dp))

            Text(text = stringResource(R.string.login), style = MaterialTheme.typography.headlineLarge)

            Spacer(Modifier.height(32.dp))

            KambioTextField(
                state = state.email,
                startIcon = null,
                endIcon = null,
                hint = stringResource(R.string.email_hint),
                title = stringResource(R.string.email_text_input),
            )

            Spacer(Modifier.height(32.dp))

            KambioPasswordTextField(
                state = state.password,
                isPasswordVisible = state.isPasswordVisible,
                hint = stringResource(R.string.password_hint),
                title = stringResource(R.string.password_text_input),
                onTogglePasswordVisibility = { onAction(LoginAction.OnTogglePasswordVisibility) }
            )

            Spacer(Modifier.height(16.dp))

            KambioTextButton(
                text = stringResource(R.string.forgot_password_text_button)
            ) { onAction(LoginAction.onRecoverPasswordClick) }


            Spacer(Modifier.weight(1f))

            KambioPrimaryButton(
                text = stringResource(R.string.login_button),
                isLoading = state.isLoggingIn,
            ) {
                onAction(LoginAction.OnLoginClick)
            }

            Spacer(Modifier.height(8.dp))

            KambioTextButton(
                text = stringResource(R.string.register_text_button)
            ) {
                onAction(LoginAction.OnRegisterClick)
            }

        }
    }
}