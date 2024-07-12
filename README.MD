# Easy Date Picker

Easy Date Picker is a Kotlin Multiplatform library for selecting date and time in your Android or iOS App. It offers a customizable UI to use in your multiplatform projects.

![Hero-image 2 2](https://github.com/ChainTechNetwork/compose_multiplatform_date_time_picker/assets/143475887/8ad09437-ad9e-4885-8ec9-99f644b54a3e)


## Installation

Add the dependency to your `build.gradle.kts` file:

```kotlin
commonMain.dependencies {
    implementation("network.chaintech:kmp-date-time-picker:1.0.2")
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
	 dateTextStyle: TextStyle = MaterialTheme.typography.titleMedium, 
	 dateTextColor: Color = LocalContentColor.current, 
	 hideHeader: Boolean = false, 
	 containerColor: Color = Color.White, 
	 shape: Shape = RoundedCornerShape(10.dp), 
	 dateTimePickerView: DateTimePickerView = DateTimePickerView.BOTTOM_SHEET_VIEW, 
	 selectorProperties: SelectorProperties = WheelPickerDefaults.selectorProperties(), 
	 dragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() }, 
	 onDoneClick: (snappedDate: LocalDate) -> Unit = {}, 
	 onDateChangeListener: (snappedDate: LocalDate) -> Unit = {}, 
	 onDismiss: () -> Unit = {}, 
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
	 dateTextStyle: TextStyle = MaterialTheme.typography.titleMedium, 
	 dateTextColor: Color = LocalContentColor.current, 
	 hideHeader: Boolean = false, 
	 selectorProperties: SelectorProperties = WheelPickerDefaults.selectorProperties(), 
	 onDoneClick: (snappedDate: LocalDate) -> Unit = {}, 
	 onDateChangeListener: (snappedDate: LocalDate) -> Unit = {}, 
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
* `dateTextStyle`: Text style for the date display.
* `dateTextColor`: Text color for the date display.
* `hideHeader`: Hide header of picker.
* `selectorProperties`: Properties defining the interaction with the date picker.
* `onDoneClick`: Callback triggered when the "Done" button is clicked, passing the selected date.
* `onDateChangeListener`: Callback triggered when the Date is changed, passing the selected date.

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
WheelDateTimePickerView( 
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
	 dateTextStyle: TextStyle = MaterialTheme.typography.titleMedium, 
	 dateTextColor: Color = LocalContentColor.current, 
	 hideHeader: Boolean = false, 
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
WheelDateTimePicker( 
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
	 dateTextStyle: TextStyle = MaterialTheme.typography.titleMedium, 
	 dateTextColor: Color = LocalContentColor.current, 
	 hideHeader: Boolean = false, 
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
* `dateTextStyle`: Text style for the datetime display.
* `dateTextColor`: Text color for the datetime display.
* `hideHeader`: Hide header of picker.
* `selectorProperties`: Properties defining the interaction with the datetime picker.
* `onDoneClick`: Callback triggered when the "Done" button is clicked, passing the selected datetime.
* `onDateChangeListener`: Callback triggered when the Date is changed, passing the selected datetime.
     
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
WheelTimePickerView( 
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
	 height: Dp, 
	 rowCount: Int = 3, 
	 textStyle: TextStyle = MaterialTheme.typography.titleMedium, 
	 textColor: Color = LocalContentColor.current, 
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
WheelTimePicker( 
	 modifier: Modifier = Modifier, 
	 title: String = "TIME PICKER", 
	 doneLabel: String = "Done", 
	 titleStyle: TextStyle = LocalTextStyle.current, 
	 doneLabelStyle: TextStyle = LocalTextStyle.current, 
	 startTime: LocalTime = LocalTime.now(), 
	 minTime: LocalTime = LocalTime.MIN(), 
	 maxTime: LocalTime = LocalTime.MAX(), 
	 timeFormat: TimeFormat = TimeFormat.HOUR_24, 
	 height: Dp, 
	 rowCount: Int = 3, 
	 textStyle: TextStyle = MaterialTheme.typography.titleMedium, 
	 textColor: Color = LocalContentColor.current, 
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
* `startTime`: Initial time selected in the picker.
* `minTime`: Minimum selectable time.
* `maxTime`: Maximum selectable time.
* `timeFormat`: Format for displaying time (e.g., 24-hour format).
* `height`: height of the time picker component.
* `rowCount`: Number of rows displayed in the picker and it's depending on height also.
* `textStyle`: Text style for the time display.
* `textColor`: Text color for the time display.
* `hideHeader`: Hide header of picker.
* `selectorProperties`: Properties defining the interaction with the time picker.
* `onDoneClick`: Callback triggered when the "Done" button is clicked, passing the selected time.
* `onTimeChangeListener`: Callback triggered when the time is changed, passing the selected time.
