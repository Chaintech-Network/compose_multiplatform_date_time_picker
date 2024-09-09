package network.chaintech.kmpdatetimepickerdemo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import datetimepicker.composeapp.generated.resources.Res
import datetimepicker.composeapp.generated.resources.img
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class DatePickerListScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val datePickerList =
            listOf(
                "WheelDatePickerBottomSheet",
                "WheelDatePickerDialog",
                "WheelDatePickerCustom",
                "WheelDateTimePickerBottomSheet",
                "WheelDateTimePickerDialog",
                "WheelDateTimePickerCustom",
                "WheelTimePickerBottomSheet",
                "WheelTimePickerDialog",
                "WheelTimePickerCustom",
            )
        MaterialTheme {
            Scaffold(
                topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF007AFF),
                            titleContentColor = Color.White,
                        ),
                        title = {
                            Text(
                                text = "Date Pickers",
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        }
                    )
                },
            ) {
                LazyVerticalGrid(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp),
                    contentPadding = it,
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    columns = GridCells.Fixed(2),
                    content = {
                        items(count = datePickerList.size) { index ->
                            val category = datePickerList[index]
                            CategoryListItem(
                                category = category,
                                onClick = {
                                    goToComponentActivity(
                                        navigator = navigator,
                                        category = category
                                    )
                                }
                            )
                        }
                    }
                )
            }
        }
    }

    @Composable
    fun CategoryListItem(
        category: String,
        onClick: () -> Unit
    ) {
        Card(
            modifier = Modifier
                .clickable {
                    onClick()
                },
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(modifier = Modifier) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    painter = painterResource(resource = Res.drawable.img),
                    contentScale = ContentScale.Fit,
                    contentDescription = ""
                )

                Text(
                    text = category,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }

    private fun goToComponentActivity(
        navigator: Navigator,
        category: String
    ) {
        navigator.push(
            ComponentListScreen(
                category = category
            )
        )
    }
}

data class ComponentListScreen(
    val category: String
) : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF007AFF),
                        titleContentColor = Color.White,
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
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    tint = Color.White,
                                    contentDescription = "Back"
                                )
                            }
                            Text(
                                text = when (category) {
                                    "WheelDatePickerBottomSheet", "WheelDatePickerDialog", "WheelDatePickerCustom" -> "Date Picker"
                                    "WheelDateTimePickerBottomSheet", "WheelDateTimePickerDialog", "WheelDateTimePickerCustom" -> "Date Time Picker"
                                    "WheelTimePickerBottomSheet", "WheelTimePickerDialog", "WheelTimePickerCustom" -> "Time Picker"
                                    else -> ""
                                },
                                fontSize = 18.sp,
                                color = Color.White,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        }
                    }
                )
            },
        ) {
            when (category) {
                "WheelDatePickerBottomSheet" -> WheelDatePickerBottomSheet()
                "WheelDatePickerDialog" -> WheelDatePickerDialog()
                "WheelDatePickerCustom" -> WheelDatePickerCustom()
                "WheelDateTimePickerBottomSheet" -> WheelDateTimePickerBottomSheet()
                "WheelDateTimePickerDialog" -> WheelDateTimePickerDialog()
                "WheelDateTimePickerCustom" -> WheelDateTimePickerCustom()
                "WheelTimePickerBottomSheet" -> WheelTimePickerBottomSheet()
                "WheelTimePickerDialog" -> WheelTimePickerDialog()
                "WheelTimePickerCustom" -> WheelTimePickerCustom()
            }
        }
    }
}
