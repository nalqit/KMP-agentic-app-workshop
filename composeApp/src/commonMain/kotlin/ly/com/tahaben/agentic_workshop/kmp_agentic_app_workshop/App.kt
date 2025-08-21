package ly.com.tahaben.agentic_workshop.kmp_agentic_app_workshop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

import kotlinx.coroutines.launch

@Composable
@Preview
fun App() {
    MaterialTheme {
        val geminiApi = remember { geminiAI() }
        val scope = rememberCoroutineScope()
        var question by remember { mutableStateOf("") }
        var screentxt by remember { mutableStateOf("") }
        val scrollState = rememberScrollState()
        val isloading = remember { mutableStateOf(false) }
        val isclearable = remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                /*.fillMaxWidth(),*/
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        TextField(
            value = question,
            onValueChange = {newText -> question = newText},
            label = {Text("enter the quetion")}
        )
        Button(onClick = {
            isloading.value = true
            isclearable.value = false
            try{
                scope.launch {
                geminiApi.generateContent(prompt = question)
                    .collect { response ->
                        println("response =  ${response.text}")
                        screentxt += "${response.text}"
                        isloading.value = false


                    }


            }
            } catch (e:Exception){
                e.printStackTrace()
                isloading.value = false
            }


        },

            enabled = !isloading.value
        )
            {
            Text("ask AI")
        }
            Button(onClick = {

                screentxt = ""
                isclearable.value = true

            },
                enabled = !isclearable.value
            ){
                Text("Clear")
            }
            /*Text(text = screentxt)*/


        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .safeContentPadding()
        ) {
            Text(text = screentxt)
        }
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