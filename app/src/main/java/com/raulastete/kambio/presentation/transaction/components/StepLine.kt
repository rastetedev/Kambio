package com.raulastete.kambio.presentation.transaction.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.raulastete.kambio.R
import com.raulastete.kambio.ui.theme.KambioTheme

enum class Step {
    SUMMARY, DESTINATION_ACCOUNT, VALIDATION;

    fun toPrintedName(): Int {
        return when (this) {
            SUMMARY -> R.string.summary_step
            DESTINATION_ACCOUNT -> R.string.destination_account_info_step
            VALIDATION -> R.string.validation_step
        }
    }

}

@Composable
fun StepLine(
    activeStep: Step = Step.SUMMARY,
    stepSize: Dp = 16.dp,
    lineWidth: Dp = 100.dp
) {

    val inactiveColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.40f)
    val activeColor = MaterialTheme.colorScheme.onBackground

    ConstraintLayout {

        val (step1, step2, step3, stepLabel1, stepLabel2, stepLabel3, line1, line2) = createRefs()

        Text(
            text = stringResource(Step.SUMMARY.toPrintedName()),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.constrainAs(stepLabel1) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            },
            color = activeColor
        )

        Box(
            modifier = Modifier
                .size(stepSize)
                .background(
                    color = activeColor,
                    shape = CircleShape
                )
                .constrainAs(step1) {
                    bottom.linkTo(stepLabel1.top)
                    start.linkTo(stepLabel1.start)
                    end.linkTo(stepLabel1.end)
                }
        )

        Box(
            modifier = Modifier
                .size(stepSize)
                .background(
                    color = if (activeStep != Step.SUMMARY) activeColor else inactiveColor,
                    shape = CircleShape
                )
                .constrainAs(step2) {
                    top.linkTo(step1.top)
                    start.linkTo(step1.end, margin = lineWidth)
                }
        )

        Text(
            text = stringResource(Step.DESTINATION_ACCOUNT.toPrintedName()),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.constrainAs(stepLabel2) {
                top.linkTo(step2.bottom)
                start.linkTo(step2.start)
                end.linkTo(step2.end)
            },
            color = if (activeStep != Step.SUMMARY) activeColor else inactiveColor,
        )

        Box(
            modifier = Modifier
                .size(stepSize)
                .background(
                    color = if (activeStep == Step.VALIDATION) activeColor else inactiveColor,
                    shape = CircleShape
                )
                .constrainAs(step3) {
                    top.linkTo(step2.top)
                    start.linkTo(step2.end, margin = lineWidth)
                }
        )

        Text(
            text = stringResource(Step.VALIDATION.toPrintedName()),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.constrainAs(stepLabel3) {
                top.linkTo(step3.bottom)
                start.linkTo(step3.start)
                end.linkTo(step3.end)
            },
            color = if (activeStep == Step.VALIDATION) activeColor else inactiveColor
        )

        Box(
            Modifier
                .height(height = 2.dp)
                .background(color = if (activeStep != Step.SUMMARY) activeColor else inactiveColor,)
                .constrainAs(line1) {
                    top.linkTo(step1.top)
                    bottom.linkTo(step1.bottom)
                    start.linkTo(step1.end)
                    end.linkTo(step2.start)
                    width = Dimension.fillToConstraints
                }
        )


        Box(
            Modifier
                .height(2.dp)
                .background(color = if (activeStep == Step.VALIDATION) activeColor else inactiveColor,)
                .constrainAs(line2) {
                    top.linkTo(step2.top)
                    bottom.linkTo(step2.bottom)
                    start.linkTo(step2.end)
                    end.linkTo(step3.start)
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTimeline() {
    KambioTheme {
        StepLine()
    }
}