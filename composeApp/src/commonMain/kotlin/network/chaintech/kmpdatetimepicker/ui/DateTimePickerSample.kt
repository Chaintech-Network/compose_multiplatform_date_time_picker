package network.chaintech.kmpdatetimepicker.ui

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import network.chaintech.kmp_date_time_picker.ui.datetimepicker.WheelDateTimePickerComponent
import network.chaintech.kmp_date_time_picker.ui.datetimepicker.WheelDateTimePickerView
import network.chaintech.kmp_date_time_picker.utils.DateTimePickerView
import network.chaintech.kmp_date_time_picker.utils.TimeFormat
import network.chaintech.kmp_date_time_picker.utils.WheelPickerDefaults
import network.chaintech.kmp_date_time_picker.utils.dateTimeToString

@Composable
fun WheelDateTimePickerBottomSheet() {
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }

    if (showDatePicker) {
        WheelDateTimePickerView(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp, bottom = 26.dp),
            showDatePicker = showDatePicker,
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
            selectorProperties = WheelPickerDefaults.selectorProperties(
                borderColor = Color.LightGray,
            ),
            timeFormat = TimeFormat.AM_PM,
            dateTextColor = Color(0xff007AFF),
            rowCount = 5,
            height = 170.dp,
            dateTextStyle = TextStyle(
                fontWeight = FontWeight(600),
            ),
            dragHandle = {
                HorizontalDivider(
                    modifier = Modifier.padding(top = 8.dp).width(50.dp).clip(CircleShape),
                    thickness = 4.dp,
                    color = Color(0xFFE8E4E4)
                )
            },
            shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp),
            onDoneClick = {
                selectedDate = dateTimeToString(it, "yyyy-MM-dd hh:mm a")
                showDatePicker = false
            },
            dateTimePickerView = DateTimePickerView.BOTTOM_SHEET_VIEW,
            onDismiss = {
                showDatePicker = false
            }
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .height(200.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    showDatePicker = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF)),
            ) {
                Text(
                    text = "Show Date Time Picker",
                    modifier = Modifier.background(Color.Transparent)
                        .padding(horizontal = 12.dp, vertical = 12.dp),
                    fontSize = 16.sp
                )
            }
            Text(
                text = selectedDate,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun WheelDateTimePickerDialog() {
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }

    if (showDatePicker) {
        WheelDateTimePickerView(
            modifier = Modifier.padding(top = 18.dp, bottom = 10.dp).fillMaxWidth(),
            showDatePicker = showDatePicker,
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
            selectorProperties = WheelPickerDefaults.selectorProperties(
                borderColor = Color.LightGray,
            ),
            timeFormat = TimeFormat.AM_PM,
            dateTextColor = Color(0xff007AFF),
            rowCount = 5,
            height = 170.dp,
            dateTextStyle = TextStyle(
                fontWeight = FontWeight(600),
            ),
            onDoneClick = {
                selectedDate = dateTimeToString(it, "yyyy-MM-dd hh:mm a")
                showDatePicker = false
            },
            dateTimePickerView = DateTimePickerView.DIALOG_VIEW,
            onDismiss = {
                showDatePicker = false
            }
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .height(200.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    showDatePicker = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF)),
            ) {
                Text(
                    text = "Show Date Time Picker",
                    modifier = Modifier.background(Color.Transparent)
                        .padding(horizontal = 12.dp, vertical = 12.dp),
                    fontSize = 16.sp
                )
            }
            Text(
                text = selectedDate,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun WheelDateTimePickerCustom() {
    var date by remember { mutableStateOf("--") }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalDivider(
            modifier = Modifier.padding(top = 10.dp),
            thickness = (0.5).dp,
            color = Color.LightGray
        )
        WheelDateTimePickerComponent.WheelDateTimePicker(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            dateTextColor = Color(0xff007AFF),
            selectorProperties = WheelPickerDefaults.selectorProperties(
                borderColor = Color.LightGray,
            ),
            timeFormat = TimeFormat.AM_PM,
            rowCount = 5,
            height = 180.dp,
            dateTextStyle = TextStyle(
                fontWeight = FontWeight(600),
            ),
            onDateChangeListener = {
                date = dateTimeToString(it, "yyyy-MM-dd hh:mm a")
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
                text = "Selected Date & Time :",
                modifier = Modifier,
            )
            Spacer(modifier = Modifier.weight(1f).height(1.dp))
            Text(
                text = date,
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
