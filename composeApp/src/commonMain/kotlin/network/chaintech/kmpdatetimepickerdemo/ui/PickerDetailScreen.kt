package network.chaintech.kmpdatetimepickerdemo.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import datetimepicker.composeapp.generated.resources.Res
import datetimepicker.composeapp.generated.resources.SFPRODISPLAYMEDIUM
import datetimepicker.composeapp.generated.resources.back
import network.chaintech.kmpdatetimepickerdemo.ui.pickers.WheelDatePickerBottomSheet
import network.chaintech.kmpdatetimepickerdemo.ui.pickers.WheelDatePickerCustom
import network.chaintech.kmpdatetimepickerdemo.ui.pickers.WheelDatePickerDialog
import network.chaintech.kmpdatetimepickerdemo.ui.pickers.WheelDateRangePickerBottomSheet
import network.chaintech.kmpdatetimepickerdemo.ui.pickers.WheelDateRangePickerCustom
import network.chaintech.kmpdatetimepickerdemo.ui.pickers.WheelDateRangePickerDialog
import network.chaintech.kmpdatetimepickerdemo.ui.pickers.WheelDateTimePickerBottomSheet
import network.chaintech.kmpdatetimepickerdemo.ui.pickers.WheelDateTimePickerCustom
import network.chaintech.kmpdatetimepickerdemo.ui.pickers.WheelDateTimePickerDialog
import network.chaintech.kmpdatetimepickerdemo.ui.pickers.WheelTimePickerBottomSheet
import network.chaintech.kmpdatetimepickerdemo.ui.pickers.WheelTimePickerCustom
import network.chaintech.kmpdatetimepickerdemo.ui.pickers.WheelTimePickerDialog
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

data class PickerDetailScreen(
    val type: Int
) : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val customFont = FontFamily(
            Font(Res.font.SFPRODISPLAYMEDIUM),
        )

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(255, 255, 255),
                        titleContentColor = Color(51, 51, 51),
                    ),
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            IconButton(
                                onClick = {
                                    navigator.pop()
                                }
                            ) {
                                Icon(
                                    painter = painterResource(Res.drawable.back),
                                    tint = Color(51, 51, 51),
                                    contentDescription = "Back"
                                )
                            }
                            Text(
                                text = when (type) {
                                    1, 2, 3 -> Constants.DATE_PICKER
                                    4, 5, 6 -> Constants.DATE_TIME_PICKER
                                    7, 8, 9 -> Constants.TIME_PICKER
                                    10, 11, 12 -> Constants.DATE_RANGE_PICKER
                                    else -> ""
                                },
                                fontFamily = customFont,
                                fontSize = 20.sp,
                                color = Color(51, 51, 51),
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        }
                    }
                )
            },
        ) {
            when (type) {
                1 -> WheelDatePickerBottomSheet()
                2 -> WheelDatePickerDialog()
                3 -> WheelDatePickerCustom()
                4 -> WheelDateTimePickerBottomSheet()
                5 -> WheelDateTimePickerDialog()
                6 -> WheelDateTimePickerCustom()
                7 -> WheelTimePickerBottomSheet()
                8 -> WheelTimePickerDialog()
                9 -> WheelTimePickerCustom()
                10 -> WheelDateRangePickerDialog()
                11 -> WheelDateRangePickerBottomSheet()
                12 -> WheelDateRangePickerCustom()
            }
        }
    }
}