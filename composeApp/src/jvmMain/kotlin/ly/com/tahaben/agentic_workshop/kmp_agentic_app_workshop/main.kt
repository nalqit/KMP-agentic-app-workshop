package ly.com.tahaben.agentic_workshop.kmp_agentic_app_workshop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "kmp_agentic_app_workshop",
    ) {
        App()
    }
}