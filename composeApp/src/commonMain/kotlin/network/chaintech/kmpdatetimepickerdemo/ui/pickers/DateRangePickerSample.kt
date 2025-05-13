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
import network.chaintech.kmp_date_time_picker.ui.date_range_picker.WheelDateRangePickerComponent.WheelDateRangePicker
import network.chaintech.kmp_date_time_picker.ui.date_range_picker.WheelDateRangePickerView
import network.chaintech.kmp_date_time_picker.utils.DateTimePickerView
import network.chaintech.kmp_date_time_picker.utils.WheelPickerDefaults
import network.chaintech.kmpdatetimepickerdemo.ui.components.CommonButton


@Composable
fun WheelDateRangePickerDialog() {

    var showDatePicker by remember { mutableStateOf(false) }
    var selectedFromDate by remember { mutableStateOf("-/-/-") }
    var selectedToDate by remember { mutableStateOf("-/-/-") }


    if (showDatePicker) {
        WheelDateRangePickerView(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp, bottom = 26.dp),
            showDatePicker = showDatePicker,
            title = "Select Date Range",
            doneLabel = "Done",
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
            rowCount = 5,
            height = 180.dp,
            defaultDateTextStyle = TextStyle(
                fontWeight = FontWeight(600),
            ),
            dragHandle = {
                HorizontalDivider(
                    modifier = Modifier.padding(top = 8.dp).width(50.dp).clip(CircleShape),
                    thickness = 4.dp,
                    color = Color(0xFFE8E4E4)
                )
            },
            shape = RoundedCornerShape(18.dp),
            dateRangeBoxShape = RoundedCornerShape(8.dp),
            dateTimePickerView = DateTimePickerView.DIALOG_VIEW,
            onDoneClick = { fromDate, toDate ->
                selectedToDate = toDate.toString()
                selectedFromDate = fromDate.toString()
                showDatePicker = false
            },
            onDismiss = {
                showDatePicker = false
            },
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(242,242,242)
    ) {
        Column(
            modifier = Modifier
                .height(200.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CommonButton(buttonText = "Show Date Range Picker", onClick = {showDatePicker = true})
            Text(
                text = "$selectedFromDate to $selectedToDate",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }

}


@Composable
fun WheelDateRangePickerBottomSheet() {

    var showDatePicker by remember { mutableStateOf(false) }
    var selectedFromDate by remember { mutableStateOf("-/-/-") }
    var selectedToDate by remember { mutableStateOf("-/-/-") }

    if (showDatePicker) {
        WheelDateRangePickerView(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp, bottom = 26.dp),
            showDatePicker = showDatePicker,
            title = "DUE DATE",
            doneLabel = "Done",
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
            rowCount = 5,
            height = 180.dp,
            defaultDateTextStyle = TextStyle(
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
            dateRangeBoxShape = RoundedCornerShape(8.dp),
            dateTimePickerView = DateTimePickerView.BOTTOM_SHEET_VIEW,
            onDoneClick = { fromDate, toDate ->
                selectedToDate = toDate.toString()
                selectedFromDate = fromDate.toString()
                showDatePicker = false
            },
            onDismiss = {
                showDatePicker = false
            },
        )
    }




    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(242,242,242)
    ) {
        Column(
            modifier = Modifier
                .height(200.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CommonButton(buttonText = "Show Date Range Picker", onClick = {showDatePicker = true})
            Text(
                text = "$selectedFromDate to $selectedToDate",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }

}


@Composable
fun WheelDateRangePickerCustom() {

    var fromDate by remember { mutableStateOf("-/-/-") }
    var toDate by remember { mutableStateOf("-/-/-") }

    Column(
        modifier = Modifier.fillMaxSize().background(Color(242,242,242)),
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalDivider(
            modifier = Modifier.padding(top = 10.dp),
            thickness = (0.5).dp,
            color = Color.LightGray
        )
        WheelDateRangePicker(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            selectorProperties = WheelPickerDefaults.selectorProperties(
                borderColor = Color.LightGray,
            ),
            rowCount = 5,
            height = 180.dp,
            defaultDateTextStyle = TextStyle(
                fontWeight = FontWeight(600),
            ),
            dateTextFormat = "yyyy-MM-dd",
            onToDateChangeListener = {
                toDate = it.toString()
            },
            onFromDateChangeListener = {
                fromDate = it.toString()
            },
            hideHeader = true,
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
                text = "Date Range :",
                modifier = Modifier,
            )
            Spacer(modifier = Modifier.weight(1f).height(1.dp))
            Text(
                text = "$fromDate to $toDate",
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