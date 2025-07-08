[![Maven Central](https://img.shields.io/maven-central/v/network.chaintech/kmp-date-time-picker.svg)](https://central.sonatype.com/artifact/network.chaintech/kmp-date-time-picker)
[![Kotlin](https://img.shields.io/badge/kotlin-v2.0.20-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.7.0-blue)](https://github.com/JetBrains/compose-multiplatform)
[![License](https://img.shields.io/github/license/Chaintech-Network/CMPCharts)](http://www.apache.org/licenses/LICENSE-2.0)

![badge-android](http://img.shields.io/badge/platform-android-3DDC84.svg?style=flat)
![badge-ios](http://img.shields.io/badge/platform-ios-FF375F.svg?style=flat)
![badge-desktop](http://img.shields.io/badge/platform-desktop-FF9500.svg?style=flat)
![badge-web](https://img.shields.io/badge/platform-web-33ceff.svg?style=flat)

# Easy Date Picker

Easy Date Picker is a Kotlin Multiplatform library for selecting date and time in your Android, iOS and Desktop App. It offers a customizable UI to use in your multiplatform projects.

![Hero-image 5 dark mode 1](https://github.com/user-attachments/assets/e5b9bfb5-f880-4f7a-949d-1d04096cdcdd)

## Installation

Add the dependency to your `build.gradle.kts` file:

```kotlin
commonMain.dependencies {
    implementation("network.chaintech:kmp-date-time-picker:1.1.1")
}
```

## Usage

### WheelDatePickerView
A composable for selecting dates using a wheel picker.

## Screenshots

<div style="display: flex;">
<img src="https://github.com/ChainTechNetwork/compose_multiplatform_date_time_picker/assets/143475887/fc0e75b1-0bfc-4808-a912-f391b3aa8416" alt="Image 3" style="width: 250px; height: auto;">
&nbsp;&nbsp;&nbsp;
<img src="https://github.com/ChainTechNetwork/compose_multiplatform_date_time_picker/assets/143475887/9154e87b-c1c1-4b19-b1a2-ecd87a03e4f9" alt="Image 2" style="width: 250px; height: auto;">
&nbsp;&nbsp;&nbsp;
<img src="https://github.com/ChainTechNetwork/compose_multiplatform_date_time_picker/assets/143475887/bce1415a-dbec-4595-83d1-d1e44f57b7d2" alt="Image 1" style="width: 250px; height: auto;">
</div>

```kotlin
WheelDatePickerView(
    modifier: Modifier = Modifier,
    showDatePicker: Boolean = false,
    title: String = "Due Date",
    doneLabel: String = "Done",
    titleStyle: TextStyle = LocalTextStyle.current,
    doneLabelStyle: TextStyle = LocalTextStyle.current,
    startDate: LocalDate = LocalDate.now(),
    minDate: LocalDate = LocalDate.MIN(),
    maxDate: LocalDate = LocalDate.MAX(),
    yearsRange: IntRange? = IntRange(1922, 2122),
    height: Dp,
    rowCount: Int = 3,
    showShortMonths: Boolean = false,
    showMonthAsNumber: Boolean = false,
    selectedDateTextStyle: TextStyle = MaterialTheme.typography.titleMedium.copy(
        color = LocalContentColor.current,
        fontSize = 20.sp
    ),
    defaultDateTextStyle: TextStyle = MaterialTheme.typography.titleSmall.copy(
        color = Color.Black,
        fontSize = 18.sp
    ),
    hideHeader: Boolean = false,
    customMonthNames: List<String>? = null,
    containerColor: Color = Color.White,
    shape: Shape = RoundedCornerShape(10.dp),
    dateTimePickerView: DateTimePickerView = DateTimePickerView.BOTTOM_SHEET_VIEW,
    selectorProperties: SelectorProperties = WheelPickerDefaults.selectorProperties(),
    dragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    onDoneClick: (snappedDate: LocalDate) -> Unit = {},
    onDateChangeListener: (snappedDate: LocalDate) -> Unit = {},
    onDismiss: () -> Unit = {}
) 
```

- If you want to use custom wrapper around `WheelDatePicker` use below code.

```kotlin
WheelDatePicker(
    modifier: Modifier = Modifier,
    title: String = "Due Date",
    doneLabel: String = "Done",
    titleStyle: TextStyle = LocalTextStyle.current,
    doneLabelStyle: TextStyle = LocalTextStyle.current,
    startDate: LocalDate = LocalDate.now(),
    minDate: LocalDate = LocalDate.MIN(),
    maxDate: LocalDate = LocalDate.MAX(),
    yearsRange: IntRange? = IntRange(1922, 2122),
    height: Dp = 128.dp,
    rowCount: Int = 3,
    showShortMonths: Boolean = false,
    showMonthAsNumber: Boolean = false,
    selectedDateTextStyle: TextStyle = MaterialTheme.typography.titleMedium.copy(
        color = LocalContentColor.current,
        fontSize = 18.sp
    ),
    defaultDateTextStyle: TextStyle = MaterialTheme.typography.titleSmall.copy(
        color = Color.Black,
        fontSize = 16.sp
    ),
    hideHeader: Boolean = false,
    customMonthNames: List<String>? = null,
    selectorProperties: SelectorProperties = WheelPickerDefaults.selectorProperties(),
    onDoneClick: (snappedDate: LocalDate) -> Unit = {},
    onDateChangeListener: (snappedDate: LocalDate) -> Unit = {}
) 
```

* `modifier`: Modifies the layout of the date picker.
* `title`: Title displayed above the date picker.
* `doneLabel`: Label for the "Done" button.
* `titleStyle`: Style for the title text.
* `doneLabelStyle`: Style for the "Done" label text.
* `startDate`: Initial date selected in the picker.
* `minDate`: Minimum selectable date.
* `maxDate`: Maximum selectable date.
* `yearsRange`: Initial years range.
* `height`: height of the date picker component.
* `rowCount`: Number of rows displayed in the picker and it's depending on height also.
* `showShortMonths`: show short month name.
* `showMonthAsNumber`: If true, displays months as numbers (e.g., "01" for January).
* `selectedDateTextStyle`: Text style used for the currently selected date.
* `defaultDateTextStyle`: Text style used for unselected date items in the picker.
* `hideHeader`: Hide header of picker.
* `customMonthNames`: Optional custom list of month names (e.g., localized or alternative month names).
* `selectorProperties`: Properties defining the interaction with the date picker.
* `onDoneClick`: Callback triggered when the "Done" button is clicked, passing the selected date.
* `onDateChangeListener`: Callback triggered when the Date is changed, passing the selected date.
* `showMonthAsNumber`: flag to show month as a number.



### WheelDateRangePickerView
A Composable for selecting a date range with a wheel picker.
## Screenshots

<div style="display: flex;">
<img src="https://github.com/user-attachments/assets/1c717f02-e71c-4a87-ab3f-04678839e620" alt="Image 3" style="width: 250px; height: auto;">
&nbsp;&nbsp;&nbsp;
<img src="https://github.com/user-attachments/assets/ba57e866-3e13-44b0-8c36-1fbdd06a29ab" alt="Image 2" style="width: 250px; height: auto;">
&nbsp;&nbsp;&nbsp;
<img src="https://github.com/user-attachments/assets/3ea8a22d-9537-4bb5-af70-e3445cc6222f" alt="Image 1" style="width: 250px; height: auto;">
</div>


```kotlin
fun WheelDateRangePickerView(
    modifier: Modifier = Modifier,
    showDatePicker: Boolean = false,
    title: String = "Due Date",
    doneLabel: String = "Done",
    centerText: String = "to",
    titleStyle: TextStyle = LocalTextStyle.current,
    doneLabelStyle: TextStyle = LocalTextStyle.current,
    initialFromDate: LocalDate? = null,
    initialToDate: LocalDate? = null,
    selectFutureDate: Boolean = true,
    selectPastDate: Boolean = true,
    minDate: LocalDate = LocalDate.MIN(),
    maxDate: LocalDate = LocalDate.MAX(),
    yearsRange: IntRange? = IntRange(1922, 2122),
    height: Dp,
    rowCount: Int = 3,
    showShortMonths: Boolean = false,
    showMonthAsNumber: Boolean = false,
    customMonthNames: List<String>? = null,
    selectedDateTextStyle: TextStyle = MaterialTheme.typography.titleMedium.copy(
        color = LocalContentColor.current,
        fontSize = 20.sp
    ),
    defaultDateTextStyle: TextStyle = MaterialTheme.typography.titleSmall.copy(
        color = Color.Black,
        fontSize = 18.sp
    ),
    hideHeader: Boolean = false,
    containerColor: Color = Color.White,
    shape: Shape = RoundedCornerShape(10.dp),
    dateTimePickerView: DateTimePickerView = DateTimePickerView.BOTTOM_SHEET_VIEW,
    selectorProperties: SelectorProperties = WheelPickerDefaults.selectorProperties(),
    dragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    dateRangeBoxColor: Color = Color.White,
    dateRangeSelectedBoxColor: Color = Color(233, 242, 254, 255),
    dateRangeBoxBorderColor: Color = Color.LightGray,
    dateRangeSelectedBoxBorderColor: Color = Color(153, 189, 251, 255),
    dateRangeSelectedTextColor: Color = Color(82,136,249,255),
    dateRangeBoxShape: Shape = RoundedCornerShape(8.dp),
    dateRangeTextStyle: TextStyle = TextStyle(color = Color(51,51,51), fontWeight = FontWeight.W600),
    dateTextFormat:String = "yyyy-MM-dd",
    onDoneClick: (fromDate: LocalDate, toDate: LocalDate) -> Unit = { _, _ -> },
    onFromDateChangeListener: (snappedDate: LocalDate) -> Unit = {},
    onToDateChangeListener: (snappedDate: LocalDate) -> Unit = {},
    onDismiss: () -> Unit = {},
)
```
- If you want to use custom wrapper around `WheelDateRangePicker` use below code

```kotlin
fun WheelDateRangePicker(
    modifier: Modifier = Modifier,
    title: String = "Due Date",
    doneLabel: String = "Done",
    centerText: String = "to",
    titleStyle: TextStyle = LocalTextStyle.current,
    doneLabelStyle: TextStyle = LocalTextStyle.current,
    initialFromDate: LocalDate? = null,
    initialToDate: LocalDate? = null,
    selectFutureDate: Boolean = true,
    selectPastDate: Boolean = true,
    minDate: LocalDate = LocalDate.MIN(),
    maxDate: LocalDate = LocalDate.MAX(),
    yearsRange: IntRange? = IntRange(1922, 2122),
    height: Dp = 128.dp,
    rowCount: Int = 3,
    showShortMonths: Boolean = true,
    showMonthAsNumber: Boolean = false,
    selectedDateTextStyle: TextStyle = MaterialTheme.typography.titleMedium.copy(
        color = LocalContentColor.current,
        fontSize = 20.sp
    ),
    defaultDateTextStyle: TextStyle = MaterialTheme.typography.titleSmall.copy(
        color = Color.Black,
        fontSize = 18.sp
    ),
    hideHeader: Boolean = false,
    customMonthNames: List<String>? = null,
    selectorProperties: SelectorProperties = WheelPickerDefaults.selectorProperties(),
    dateRangeBoxColor: Color = Color.White,
    dateRangeSelectedBoxColor: Color = Color(233, 242, 254, 255),
    dateRangeBoxBorderColor: Color = Color.LightGray,
    dateRangeSelectedBoxBorderColor: Color = Color(153, 189, 251, 255),
    dateRangeSelectedTextColor: Color = Color(82, 136, 249, 255),
    dateRangeBoxShape: Shape = RoundedCornerShape(8.dp),
    dateRangeTextStyle: TextStyle = TextStyle(
        color = Color(51, 51, 51),
        fontWeight = FontWeight.W600
    ),
    dateTextFormat:String = "yyyy-MM-dd",
    onDoneClick: (fromDate: LocalDate, toDate: LocalDate) -> Unit = { _, _ -> },
    onFromDateChangeListener: (fromDate: LocalDate) -> Unit = {},
    onToDateChangeListener: (fromDate: LocalDate) -> Unit = {}
)
```
* `modifier`: Modifies the layout of the date picker.
* `title`: Title displayed above the date picker.
* `doneLabel`: Label for the "Done" button.
* `titleStyle`: Style for the title text.
* `centerText`: Text between dateBox.
* `doneLabelStyle`: Style for the "Done" label text.
* `initialFromDate`: Initially assign from Date
* `initialToDate`: Initially assign to Date
* `selectFutureDate`: User can select future date.
* `selectPastDate`: User can select past date
* `minDate`: Minimum selectable date.
* `maxDate`: Maximum selectable date.
* `yearsRange`: Initial years range.
* `height`: height of the date picker component.
* `rowCount`: Number of rows displayed in the picker and it's depending on height also.
* `showShortMonths`: show short month name.
* `showMonthAsNumber`: show month number
* `selectedDateTextStyle`: Text style used for the currently selected date.
* `defaultDateTextStyle`: Text style used for unselected date items in the picker.
* `hideHeader`: Hide header of picker.
* `customMonthNames`: Optional custom list of month names (e.g., localized or alternative month names).
* `selectorProperties`: Properties defining the interaction with the date picker.
* `dateRangeBoxColor`:  Background color of the date boxes when not selected
* `dateRangeSelectedBoxColor`:  Background color of the date boxes when selected
* `dateRangeTextStyle`: TextStyle for the date text inside the boxes
* `dateRangeBoxBorderColor`: Border color of the date boxes when not selected
* `dateRangeSelectedBoxBorderColor`: Border color of the date boxes when not selected
* `dateRangeBoxShape`: Shape of the date Boxes
* `dateTextFormat`: Date Format can be changed.
* `onDoneClick`: Callback triggered when the "Done" button is clicked, passing the selected date.
* `onFromDateChangeListener`:Callback triggered when the From Date Changes, passing the From date.
* `onToDateChangeListener`:Callback triggered when the to Date Changes, passing the to date.




### WheelDateTimePickerView
A composable for selecting date & time using a wheel picker.

## Screenshots

<div style="display: flex;">
<img src="https://github.com/ChainTechNetwork/compose_multiplatform_date_time_picker/assets/143475887/b76af9b6-2659-410c-bdd6-27b1b871748e" alt="Image 3" style="width: 250px; height: auto;">
&nbsp;&nbsp;&nbsp;
<img src="https://github.com/ChainTechNetwork/compose_multiplatform_date_time_picker/assets/143475887/d391ae1a-a2e8-4305-8726-214f078305b3" alt="Image 2" style="width: 250px; height: auto;">
&nbsp;&nbsp;&nbsp;
<img src="https://github.com/ChainTechNetwork/compose_multiplatform_date_time_picker/assets/143475887/b7a1797b-2ef8-415c-b4ac-4d4960466038" alt="Image 1" style="width: 250px; height: auto;">
</div>

```kotlin
fun WheelDateTimePickerView(
    modifier: Modifier = Modifier,
    showDatePicker: Boolean = false,
    title: String = "DATE & TIME PICKER",
    doneLabel: String = "Done",
    timeFormat: TimeFormat = TimeFormat.HOUR_24,
    titleStyle: TextStyle = LocalTextStyle.current,
    doneLabelStyle: TextStyle = LocalTextStyle.current,
    startDate: LocalDateTime = LocalDateTime.now(),
    minDate: LocalDateTime = LocalDateTime.MIN(),
    maxDate: LocalDateTime = LocalDateTime.MAX(),
    yearsRange: IntRange? = IntRange(1922, 2122),
    height: Dp,
    rowCount: Int = 3,
    selectedDateTextStyle: TextStyle = MaterialTheme.typography.titleMedium.copy(
        color = LocalContentColor.current,
        fontSize = 18.sp
    ),
    defaultDateTextStyle: TextStyle = MaterialTheme.typography.titleSmall.copy(
        color = Color.Black,
        fontSize = 16.sp
    ),
    hideHeader: Boolean = false,
    showMonthAsNumber: Boolean = false,
    customMonthNames: List<String>? = null,
    containerColor: Color = Color.White,
    shape: Shape = RoundedCornerShape(10.dp),
    dateTimePickerView: DateTimePickerView = DateTimePickerView.BOTTOM_SHEET_VIEW,
    dragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    selectorProperties: SelectorProperties = WheelPickerDefaults.selectorProperties(),
    onDoneClick: (snappedDate: LocalDateTime) -> Unit = {},
    onDateChangeListener: (snappedDate: LocalDateTime) -> Unit = {},
    onDismiss: () -> Unit = {},
)  
```

- If you want to use custom wrapper around `WheelDateTimePicker` use below code.

```kotlin
fun WheelDateTimePicker(
    modifier: Modifier = Modifier,
    title: String = "DATE & TIME PICKER",
    doneLabel: String = "Done",
    titleStyle: TextStyle = LocalTextStyle.current,
    doneLabelStyle: TextStyle = LocalTextStyle.current,
    startDateTime: LocalDateTime = LocalDateTime.now(),
    minDateTime: LocalDateTime = LocalDateTime.MIN(),
    maxDateTime: LocalDateTime = LocalDateTime.MAX(),
    yearsRange: IntRange? = IntRange(1922, 2122),
    timeFormat: TimeFormat = TimeFormat.HOUR_24,
    height: Dp = 128.dp,
    rowCount: Int = 3,
    selectedTextStyle: TextStyle = MaterialTheme.typography.titleMedium.copy(
        color = LocalContentColor.current,
        fontSize = 18.sp
    ),
    defaultTextStyle: TextStyle = MaterialTheme.typography.titleSmall.copy(
        color = Color.Black,
        fontSize = 16.sp
    ),
    hideHeader: Boolean = false,
    showMonthAsNumber: Boolean = false,
    customMonthNames: List<String>? = null,
    showShortMonths: Boolean = false,
    selectorProperties: SelectorProperties = WheelPickerDefaults.selectorProperties(),
    onDoneClick: (snappedDate: LocalDateTime) -> Unit = {},
    onDateChangeListener: (snappedDate: LocalDateTime) -> Unit = {},
)
```

* `modifier`: Modifies the layout of the datetime picker.
* `title`: Title displayed above the datetime picker.
* `doneLabel`: Label for the "Done" button.
* `titleStyle`: Style for the title text.
* `doneLabelStyle`: Style for the "Done" label text.
* `minDateTime`: Minimum selectable datetime.
* `maxDateTime`: Maximum selectable datetime.
* `yearsRange`: Initial years range.
* `timeFormat`: Format for displaying time (e.g., 24-hour format).
* `height`: height of the datetime picker component.
* `rowCount`: Number of rows displayed in the picker and it's depending on height also.
* `selectedDateTextStyle`: Text style used for the currently selected date.
* `defaultDateTextStyle`: Text style used for unselected date items in the picker.
* `hideHeader`: Hide header of picker.
* `customMonthNames`: Optional custom list of month names (e.g., localized or alternative month names).
* `showShortMonths`: show short month name.
* `showMonthAsNumber`: show month number 
* `selectorProperties`: Properties defining the interaction with the datetime picker.
* `onDoneClick`: Callback triggered when the "Done" button is clicked, passing the selected datetime.
* `onDateChangeListener`: Callback triggered when the Date is changed, passing the selected datetime.
* `showMonthAsNumber`: flag to show month as a number.

### WheelTimePickerView
A composable for selecting time using a wheel picker.

## Screenshots

<div style="display: flex;">
<img src="https://github.com/ChainTechNetwork/compose_multiplatform_date_time_picker/assets/143475887/c0d05d9f-8c41-4e93-8b09-78272ba705c8" alt="Image 3" style="width: 250px; height: auto;">
&nbsp;&nbsp;&nbsp;
<img src="https://github.com/ChainTechNetwork/compose_multiplatform_date_time_picker/assets/143475887/ca41425b-f706-4275-83e0-9b3bd0a8909c" alt="Image 2" style="width: 250px; height: auto;">
&nbsp;&nbsp;&nbsp;
<img src="https://github.com/ChainTechNetwork/compose_multiplatform_date_time_picker/assets/143475887/080e508a-d097-4338-ace2-b0e9de2684de" alt="Image 1" style="width: 250px; height: auto;">
</div>

```kotlin
fun WheelTimePickerView(
    modifier: Modifier = Modifier,
    showTimePicker: Boolean = false,
    title: String = "TIME PICKER",
    doneLabel: String = "Done",
    titleStyle: TextStyle = LocalTextStyle.current,
    doneLabelStyle: TextStyle = LocalTextStyle.current,
    startTime: LocalTime = LocalTime.now(),
    minTime: LocalTime = LocalTime.MIN(),
    maxTime: LocalTime = LocalTime.MAX(),
    timeFormat: TimeFormat = TimeFormat.HOUR_24,
    showSeconds: Boolean = false,
    height: Dp,
    rowCount: Int = 3,
    selectedTextStyle: TextStyle = MaterialTheme.typography.titleMedium.copy(
        color = LocalContentColor.current,
        fontSize = 20.sp
    ),
    defaultTextStyle: TextStyle = MaterialTheme.typography.titleSmall.copy(
        color = Color.Black,
        fontSize = 18.sp
    ),
    hideHeader: Boolean = false,
    containerColor: Color = Color.White,
    shape: Shape = RoundedCornerShape(10.dp),
    dateTimePickerView: DateTimePickerView = DateTimePickerView.BOTTOM_SHEET_VIEW,
    dragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    selectorProperties: SelectorProperties = WheelPickerDefaults.selectorProperties(),
    onDoneClick: (snappedDate: LocalTime) -> Unit = {},
    onTimeChangeListener: (snappedDate: LocalTime) -> Unit = {},
    onDismiss: () -> Unit = {},
)   
```

- If you want to use custom wrapper around `WheelTimePicker` use below code.

```kotlin
fun WheelTimePicker(
    modifier: Modifier = Modifier,
    title: String = "TIME PICKER",
    doneLabel: String = "Done",
    titleStyle: TextStyle = LocalTextStyle.current,
    doneLabelStyle: TextStyle = LocalTextStyle.current,
    showSeconds: Boolean = false,
    startTime: LocalTime = LocalTime.now(),
    minTime: LocalTime = LocalTime.MIN(),
    maxTime: LocalTime = LocalTime.MAX(),
    timeFormat: TimeFormat = TimeFormat.HOUR_24,
    height: Dp,
    rowCount: Int = 3,
    selectedTextStyle: TextStyle = MaterialTheme.typography.titleMedium.copy(
        color = LocalContentColor.current,
        fontSize = 20.sp
    ),
    defaultTextStyle: TextStyle = MaterialTheme.typography.titleSmall.copy(
        color = Color.Black,
        fontSize = 18.sp
    ),
    hideHeader: Boolean = false,
    selectorProperties: SelectorProperties = WheelPickerDefaults.selectorProperties(),
    onDoneClick: (snappedDate: LocalTime) -> Unit = {},
    onTimeChangeListener: (snappedDate: LocalTime) -> Unit = {},
)  
```
* `modifier`: Modifies the layout of the time picker.
* `title`: Title displayed above the time picker.
* `doneLabel`: Label for the "Done" button.
* `titleStyle`: Style for the title text.
* `doneLabelStyle`: Style for the "Done" label text.
* `showSeconds`: If true, the time picker also includes seconds selection.
* `startTime`: Initial time selected in the picker.
* `minTime`: Minimum selectable time.
* `maxTime`: Maximum selectable time.
* `timeFormat`: Format for displaying time (e.g., 24-hour format).
* `height`: height of the time picker component.
* `rowCount`: Number of rows displayed in the picker and it's depending on height also.
* `selectedDateTextStyle`: Text style used for the currently selected date.
* `defaultDateTextStyle`: Text style used for unselected date items in the picker.
* `hideHeader`: Hide header of picker.
* `selectorProperties`: Properties defining the interaction with the time picker.
* `onDoneClick`: Callback triggered when the "Done" button is clicked, passing the selected time.
* `onTimeChangeListener`: Callback triggered when the time is changed, passing the selected time.

- For Demo [Checkout This Class](https://github.com/Chaintech-Network/compose_multiplatform_date_time_picker/blob/main/composeApp/src/commonMain/kotlin/network/chaintech/kmpdatetimepickerdemo/App.kt)
- [Medium Article](https://medium.com/mobile-innovation-network/easy-wheeldatetimepicker-compose-multiplatform-kmp-345b933c33b4) for detailed explaination.
<br><br>

## 🌐 Stay Connected with Us
Stay connected and keep up with our latest innovations! 💼 Let's innovate together!<br><br>
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/showcase/mobile-innovation-network)
[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/mobile-innovation-network)   
<br>

## 📄 License
```
Copyright 2023 Mobile Innovation Network 
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```