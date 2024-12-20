package network.chaintech.kmpdatetimepickerdemo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import datetimepicker.composeapp.generated.resources.Res
import datetimepicker.composeapp.generated.resources.calender
import datetimepicker.composeapp.generated.resources.date
import datetimepicker.composeapp.generated.resources.dialog
import datetimepicker.composeapp.generated.resources.sheet
import network.chaintech.kmpdatetimepickerdemo.ui.components.DatePickerListHeader
import network.chaintech.kmpdatetimepickerdemo.ui.components.SelectDatePickerRow
import network.chaintech.kmpdatetimepickerdemo.ui.components.TabBox
import org.jetbrains.compose.resources.DrawableResource


class DatePickerListScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val tabText = listOf(
            "  All  ",
            Constants.DATE_PICKER,
            Constants.DATE_RANGE_PICKER,
            Constants.TIME_PICKER,
            Constants.DATE_TIME_PICKER
        )

        val navigationBarsPadding = with(LocalDensity.current) {
            WindowInsets.navigationBars.getBottom(LocalDensity.current).toDp()
        }

        val datePickerList = listOf(
            DatePickerList(
                id = 1,
                icon = Res.drawable.calender,
                iconBackgroundColor = Color(150, 130, 245),
                title = "Wheel Date Picker Bottom Sheet",
                backgroundColor = Color(105, 76, 241),
                type = Constants.DATE_PICKER
            ),
            DatePickerList(
                id = 2,
                icon = Res.drawable.dialog,
                iconBackgroundColor = Color(254, 216, 123),
                isTextWhite = false,
                title = "Wheel Date Picker Dialog",
                backgroundColor = Color(253, 199, 66),
                type = Constants.DATE_PICKER
            ),
            DatePickerList(
                id = 3,
                icon = Res.drawable.date,
                iconBackgroundColor = Color(213, 225, 142),
                isTextWhite = false,
                title = "Wheel Date Picker Custom",
                backgroundColor = Color(195, 212, 93),
                type = Constants.DATE_PICKER
            ),
            DatePickerList(
                id = 4,
                icon = Res.drawable.sheet,
                iconBackgroundColor = Color(121, 121, 121),
                title = "Wheel Date Time Picker Bottom Sheet",
                backgroundColor = Color(63, 63, 63),
                type = Constants.DATE_TIME_PICKER
            ),
            DatePickerList(
                id = 5,
                icon = Res.drawable.dialog,
                iconBackgroundColor = Color(150, 213, 241),
                title = "Wheel Date Time Picker Dialog",
                backgroundColor = Color(105, 195, 235),
                type = Constants.DATE_TIME_PICKER
            ),
            DatePickerList(
                id = 6,
                icon = Res.drawable.calender,
                iconBackgroundColor = Color(184, 230, 163),
                isTextWhite = false,
                title = "Wheel Date Time Picker Custom",
                backgroundColor = Color(154, 219, 124),
                type = Constants.DATE_TIME_PICKER
            ),
            DatePickerList(
                id = 7,
                icon = Res.drawable.sheet,
                iconBackgroundColor = Color(255, 157, 164),
                title = "Wheel Time Picker Bottom Sheet",
                backgroundColor = Color(255, 115, 125),
                type = Constants.TIME_PICKER
            ),
            DatePickerList(
                id = 8,
                icon = Res.drawable.dialog,
                iconBackgroundColor = Color(159, 170, 215),
                title = "Wheel Time Picker Dialog",
                backgroundColor = Color(118, 134, 198),
                type = Constants.TIME_PICKER
            ),
            DatePickerList(
                id = 9,
                icon = Res.drawable.calender,
                iconBackgroundColor = Color(150, 130, 245),
                title = "Wheel Time Picker Custom",
                backgroundColor = Color(105, 76, 241),
                type = Constants.TIME_PICKER
            ),
            DatePickerList(
                id = 10,
                isTextWhite = false,
                icon = Res.drawable.dialog,
                iconBackgroundColor = Color(254, 216, 123),
                title = "Wheel Date Range Picker Dialog",
                backgroundColor = Color(253, 199, 66),
                type = Constants.DATE_RANGE_PICKER
            ),
            DatePickerList(
                id = 11,
                isTextWhite = false,
                icon = Res.drawable.sheet,
                iconBackgroundColor = Color(213, 225, 142),
                title = "Wheel Date Range Picker Bottom Sheet",
                backgroundColor = Color(195, 212, 93),
                type = Constants.DATE_RANGE_PICKER
            ),
            DatePickerList(
                id = 12,
                icon = Res.drawable.calender,
                iconBackgroundColor = Color(121, 121, 121),
                title = "Wheel Date Range Picker Custom",
                backgroundColor = Color(63, 63, 63),
                type = Constants.DATE_RANGE_PICKER
            )
        )

        var selectedTabIndex by rememberSaveable { mutableStateOf(0) }

        MaterialTheme {
            Scaffold(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(
                        bottom = navigationBarsPadding + 20.dp
                    )
            ) {
                val scrollState = rememberScrollState()

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {

                    DatePickerListHeader()

                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item { Spacer(Modifier.padding(4.dp)) }
                        items(tabText.size) { index ->
                            TabBox(
                                isSelected = index == selectedTabIndex,
                                title = tabText[index]
                            ) {
                                selectedTabIndex = index
                            }
                        }
                        item { Spacer(Modifier.padding(4.dp)) }

                    }
                    Spacer(Modifier.padding(12.dp))

                    val filteredList = datePickerList.filter { listItem ->
                        when (selectedTabIndex) {
                            1 -> listItem.type == Constants.DATE_PICKER
                            2 -> listItem.type == Constants.DATE_RANGE_PICKER
                            3 -> listItem.type == Constants.TIME_PICKER
                            4 -> listItem.type == Constants.DATE_TIME_PICKER
                            else -> true
                        }
                    }

                    filteredList.forEachIndexed { index, datePickerList ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 7.dp),
                        ) {
                            SelectDatePickerRow(
                                isLeftAligned = (index + 1) % 2 != 0,
                                icon = datePickerList.icon,
                                title = datePickerList.title,
                                isTextWhite = datePickerList.isTextWhite,
                                color = datePickerList.backgroundColor,
                                iconBackgroundColor = datePickerList.iconBackgroundColor
                            ) {
                                goToComponentActivity(
                                    navigator = navigator,
                                    type = datePickerList.id
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun goToComponentActivity(
        navigator: Navigator,
        type: Int
    ) {
        navigator.push(
            PickerDetailScreen(
                type = type
            )
        )
    }
}

data class DatePickerList(
    val id: Int = 0,
    val icon: DrawableResource,
    val title: String,
    val type: String,
    val isTextWhite: Boolean = true,
    val backgroundColor: Color,
    val iconBackgroundColor: Color,
)

object Constants {
    const val DATE_PICKER = "Date Picker"
    const val DATE_RANGE_PICKER = "Date Range Picker"
    const val TIME_PICKER = "Time Picker"
    const val DATE_TIME_PICKER = "Date Time Picker"
}