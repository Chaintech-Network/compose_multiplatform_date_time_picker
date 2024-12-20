package network.chaintech.kmpdatetimepickerdemo.ui.pickers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import network.chaintech.kmp_date_time_picker.ui.timepicker.WheelTimePickerComponent
import network.chaintech.kmp_date_time_picker.ui.timepicker.WheelTimePickerView
import network.chaintech.kmp_date_time_picker.utils.DateTimePickerView
import network.chaintech.kmp_date_time_picker.utils.TimeFormat
import network.chaintech.kmp_date_time_picker.utils.WheelPickerDefaults
import network.chaintech.kmp_date_time_picker.utils.timeToString
import network.chaintech.kmpdatetimepickerdemo.ui.components.CommonButton

@Composable
fun WheelTimePickerBottomSheet() {
    var showTimePicker by remember { mutableStateOf(false) }
    var selectedTime by remember { mutableStateOf("") }

    if (showTimePicker) {
        WheelTimePickerView(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp, bottom = 26.dp),
            showTimePicker = showTimePicker,
            titleStyle = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333),
            ),
            doneLabelStyle = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF007AFF),
            ),
            textColor = Color(0xff007AFF),
            timeFormat = TimeFormat.AM_PM,
            selectorProperties = WheelPickerDefaults.selectorProperties(
                borderColor = Color.LightGray,
            ),
            rowCount = 5,
            height = 170.dp,
            textStyle = TextStyle(
                fontWeight = FontWeight(600),
            ),
            dateTimePickerView = DateTimePickerView.BOTTOM_SHEET_VIEW,
            dragHandle = {
                HorizontalDivider(
                    modifier = Modifier.padding(top = 8.dp).width(50.dp).clip(CircleShape),
                    thickness = 4.dp,
                    color = Color(0xFFE8E4E4)
                )
            },
            shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp),
            onDoneClick = {
                selectedTime = timeToString(it, "hh:mm a")
                showTimePicker = false
            },
            onDismiss = {
                showTimePicker = false
            }
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(242,242,242)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().height(200.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CommonButton(buttonText = "Show Time Picker", onClick = {showTimePicker = true})
            Text(
                text = selectedTime,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun WheelTimePickerDialog() {
    var showTimePicker by remember { mutableStateOf(false) }
    var selectedTime by remember { mutableStateOf("") }

    if (showTimePicker) {
        WheelTimePickerView(
            modifier = Modifier.padding(top = 18.dp, bottom = 10.dp).fillMaxWidth(),
            showTimePicker = showTimePicker,
            titleStyle = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333),
            ),
            doneLabelStyle = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF007AFF),
            ),
            textColor = Color(0xff007AFF),
            timeFormat = TimeFormat.AM_PM,
            selectorProperties = WheelPickerDefaults.selectorProperties(
                borderColor = Color.LightGray,
            ),
            rowCount = 5,
            height = 170.dp,
            textStyle = TextStyle(
                fontWeight = FontWeight(600),
            ),
            dateTimePickerView = DateTimePickerView.DIALOG_VIEW,
            onDoneClick = {
                selectedTime = timeToString(it, "hh:mm a")
                showTimePicker = false
            },
            onDismiss = {
                showTimePicker = false
            }
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(242,242,242)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().height(200.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CommonButton(buttonText = "Show Time Picker", onClick = {showTimePicker = true})
            Text(
                text = selectedTime,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun WheelTimePickerCustom() {
    var selectedDate by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(Color(242,242,242)),
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalDivider(
            modifier = Modifier.padding(top = 10.dp),
            thickness = (0.5).dp,
            color = Color.LightGray
        )
        WheelTimePickerComponent.WheelTimePicker(
            modifier = Modifier.padding(top = 18.dp, bottom = 10.dp).fillMaxWidth(),
            textColor = Color(0xff007AFF),
            timeFormat = TimeFormat.AM_PM,
            selectorProperties = WheelPickerDefaults.selectorProperties(
                borderColor = Color.LightGray,
            ),
            rowCount = 5,
            height = 170.dp,
            textStyle = TextStyle(
                fontWeight = FontWeight(600),
            ),
            onTimeChangeListener = {
                selectedDate = timeToString(it, "hh:mm a")
            },
            hideHeader = true
        )
        HorizontalDivider(
            modifier = Modifier.padding(top = 10.dp),
            thickness = (0.5).dp,
            color = Color.LightGray
        )
        Row(
            modifier = Modifier.padding(top = 12.dp, start = 22.dp, end = 22.dp).fillMaxWidth()
        ) {
            Text(
                text = "Selected Time :",
                modifier = Modifier,
            )
            Spacer(modifier = Modifier.weight(1f).height(1.dp))
            Text(
                text = selectedDate,
                modifier = Modifier,
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(top = 12.dp),
            thickness = (0.5).dp,
            color = Color.LightGray
        )
    }
}