import androidx.compose.ui.window.ComposeUIViewController
import network.chaintech.kmpdatetimepickerdemo.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController =
    ComposeUIViewController(configure = { enforceStrictPlistSanityCheck = false }) { App() }

