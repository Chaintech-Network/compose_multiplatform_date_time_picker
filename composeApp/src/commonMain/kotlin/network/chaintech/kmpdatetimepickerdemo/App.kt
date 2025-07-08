package network.chaintech.kmpdatetimepickerdemo

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import network.chaintech.kmpdatetimepickerdemo.ui.DateTimePickerNav

val LocalSnackBarHostState =
    compositionLocalOf<SnackbarHostState> { error("No SnackBarHostState provided") }

@Composable
fun CompositionProvider(content: @Composable (SnackbarHostState) -> Unit) {
    val snackBarHostState = remember { SnackbarHostState() }

    CompositionLocalProvider(
        LocalSnackBarHostState provides snackBarHostState,
    ) {
        content(snackBarHostState)
    }
}

@Composable
internal fun App() {
    CompositionProvider { snackBarHostState ->
        Scaffold(
            snackbarHost = {
                SnackbarHost(snackBarHostState, Modifier.padding(bottom = 30.dp))
            }
        ) {
            MaterialTheme {
                DateTimePickerNav()
            }
        }
    }
}

