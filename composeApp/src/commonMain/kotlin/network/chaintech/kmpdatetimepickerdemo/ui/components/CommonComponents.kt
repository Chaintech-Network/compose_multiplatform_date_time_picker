package network.chaintech.kmpdatetimepickerdemo.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import datetimepicker.composeapp.generated.resources.Poppins_SemiBold
import datetimepicker.composeapp.generated.resources.Res
import datetimepicker.composeapp.generated.resources.SFPRODISPLAYMEDIUM
import datetimepicker.composeapp.generated.resources.arrow
import network.chaintech.kmpdatetimepickerdemo.ui.Constants
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource


@Composable
fun CommonButton(buttonText: String, onClick: () -> Unit) {
    val customFont = FontFamily(
        Font(Res.font.SFPRODISPLAYMEDIUM),
    )
    Button(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0, 0, 0)),
        shape = RoundedCornerShape(30.dp)
    ) {
        Text(
            text = buttonText,
            fontFamily = customFont,
            modifier = Modifier.background(Color.Transparent)
                .padding(horizontal = 12.dp, vertical = 12.dp),
            fontSize = 16.sp
        )
    }
}

@Composable
fun TabBox(title: String, isSelected: Boolean = false, onClick: (Int) -> Unit) {

    val customFont = FontFamily(
        Font(Res.font.SFPRODISPLAYMEDIUM),
    )
    Box(
        modifier = Modifier
            .clickable(
                indication = null,
                interactionSource = MutableInteractionSource()
            ) {
                onClick(
                    when (title) {
                        Constants.DATE_PICKER -> 1
                        Constants.DATE_TIME_PICKER -> 4
                        Constants.TIME_PICKER -> 3
                        Constants.DATE_RANGE_PICKER -> 2
                        else -> 0
                    }
                )
            }
            .background(
                color = if (isSelected) Color(51, 51, 51) else Color(255, 255, 255),
                shape = RoundedCornerShape(30.dp)
            )
            .border(
                width = 1.dp,
                color = if (isSelected) Color(51, 51, 51) else Color(229, 229, 229),
                shape = RoundedCornerShape(30.dp)
            )
            .padding(horizontal = 9.dp, vertical = 10.dp)
            .padding(7.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontSize = 21.sp,
            color = if (isSelected) Color(255, 255, 255) else Color(51, 51, 51),
            fontFamily = customFont
        )
    }

}

@Composable
fun ReverseCurveCanvas() {
    Canvas(
        modifier = Modifier
            .size(width = 330.dp, height = 13.dp) // Larger canvas size
    ) {
        val scaleY = size.height / 10f

        val paddingStart = 40f
        val paddingEnd = 40f

        val adjustedScaleX =
            (size.width - paddingStart - paddingEnd) / 266f // Adjusted scaling range to apply padding

        val path = Path()

        path.apply {
            moveTo(
                paddingStart,
                (9.22f * scaleY - 40f)
            )
            cubicTo(
                paddingStart + (71.27f * adjustedScaleX), (3.47f * scaleY - 40f),
                paddingStart + (141.97f * adjustedScaleX), (0.42f * scaleY - 40f),
                paddingStart + (212.68f * adjustedScaleX), (2f * scaleY - 40f)
            )
            cubicTo(
                paddingStart + (225.16f * adjustedScaleX), (2.28f * scaleY - 40f),
                paddingStart + (237.86f * adjustedScaleX), (2.45f * scaleY - 40f),
                paddingStart + (250.34f * adjustedScaleX), (3.64f * scaleY - 40f)
            )
            cubicTo(
                paddingStart + (254.54f * adjustedScaleX), (4.03f * scaleY - 40f),
                paddingStart + (257.95f * adjustedScaleX), (4.76f * scaleY - 40f),
                paddingStart + (261.14f * adjustedScaleX), (6.66f * scaleY - 40f)
            )
            cubicTo(
                paddingStart + (265.54f * adjustedScaleX), (9.28f * scaleY - 40f),
                paddingStart + (263.85f * adjustedScaleX), (11.35f * scaleY - 40f),
                paddingStart + (259.33f * adjustedScaleX), (13.13f * scaleY - 40f)
            )
        }

        drawPath(
            path = path,
            color = Color(0xFFFF737D),
            style = Stroke(width = 12f)
        )
    }
}

@Composable
fun DatePickerListHeader(
    modifier: Modifier = Modifier
) {

    val customFont = FontFamily(
        Font(Res.font.SFPRODISPLAYMEDIUM),
    )
    val datePickerFont = FontFamily(
        Font(Res.font.Poppins_SemiBold)
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Date Picker",
                    fontFamily = datePickerFont,
                    fontSize = 56.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFFF6B6B),
                    modifier = Modifier
                )
                ReverseCurveCanvas()
            }
        }

        Text(
            text = "CMP Library",
            fontSize = 34.sp,
            fontFamily = customFont,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "View the demos below",
            fontSize = 20.sp,
            fontFamily = customFont,
            color = Color(147, 147, 147),
            fontWeight = FontWeight.Light
        )
    }
}


@Composable
fun SelectDatePickerRow(
    icon: DrawableResource,
    isLeftAligned: Boolean = true,
    isTextWhite: Boolean = true,
    color: Color,
    iconBackgroundColor: Color,
    title: String,
    onClick: () -> Unit
) {

    val customFont = FontFamily(
        Font(Res.font.SFPRODISPLAYMEDIUM),
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                indication = null,
                interactionSource = MutableInteractionSource()
            ) { onClick() }
            .padding(
                start = if (isLeftAligned) 0.dp else 29.dp,
                end = if (isLeftAligned) 29.dp else 0.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(82.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = if (isLeftAligned) 0.dp else 50.dp,
                        bottomStart = if (isLeftAligned) 0.dp else 50.dp,
                        topEnd = if (isLeftAligned) 50.dp else 0.dp,
                        bottomEnd = if (isLeftAligned) 50.dp else 0.dp
                    )
                )
                .background(color = color),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(start = 6.dp, end = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(CircleShape)
                        .background(color = iconBackgroundColor),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        painter = painterResource(icon),
                        contentDescription = null,
                        tint = Color.White
                    )

                }
                Text(
                    text = title,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ),
                    fontFamily = customFont,
                    fontWeight = FontWeight.W500,
                    fontSize = 20.sp,
                    color = if (isTextWhite) Color(255, 255, 255) else Color(51, 51, 51),
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f)
                )


                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(CircleShape)
                        .background(Color(255, 255, 255)),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        painter = painterResource(Res.drawable.arrow),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}