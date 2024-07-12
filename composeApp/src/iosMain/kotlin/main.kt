import androidx.compose.ui.window.ComposeUIViewController
import network.chaintech.kmpdatetimepicker.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
