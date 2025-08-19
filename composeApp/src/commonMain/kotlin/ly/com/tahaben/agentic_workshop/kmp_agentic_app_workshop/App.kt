package ly.com.tahaben.agentic_workshop.kmp_agentic_app_workshop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmp_agentic_app_workshop.composeapp.generated.resources.Res
import kmp_agentic_app_workshop.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.launch

@Composable
@Preview
fun App() {
    MaterialTheme {
        val geminiApi = remember { geminiAI() }
        val scope = rememberCoroutineScope()
        var quetion by remember { mutableStateOf("") }
        var screentxt by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        TextField(
            value = quetion,
            onValueChange = {newText -> quetion = newText},
            label = {Text("enter the quetion")}
        )
        Button(onClick = {
            scope.launch {
            geminiApi.generateContent(prompt = quetion)
                .collect { response ->
                    println("response =  ${response.text}")
                    screentxt += "${response.text}"

                }

            }

        }
            ) {
            Text("ask AI")
        }
            Text(text = screentxt)

            }
        var showContent by remember { mutableStateOf(false) }
/*
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click!")
            }


            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }*/
    }
}