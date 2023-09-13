package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selectedOption by remember { mutableStateOf("") }
            var username by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            Box(modifier = Modifier.fillMaxSize()){
                Image(painter = painterResource(id = R.drawable.bg), contentDescription ="",contentScale = ContentScale.FillBounds,
                    modifier = Modifier.matchParentSize())
            }


                        Column(

                            modifier = Modifier.background(Color.White.copy(alpha = 0.5f)).fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center

                        ) {

                            OutlinedTextField(
                                value = username,
                                onValueChange = { username = it },
                                label = { Text("Username") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                           
                            OutlinedTextField(
                                value = password,
                                onValueChange = { password = it },
                                label = { Text("Password") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            RadioButtonGroup(
                                options = listOf("Amazon", "Flipkart", "YouTube", "Twitter"),
                                selectedOption = selectedOption,
                                onOptionSelected = { selectedOption = it })
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(onClick = {
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.data = Uri.parse(
                                    when (selectedOption) {
                                        "Amazon" -> "https://www.amazon.com"
                                        "Flipkart" -> "https://www.flipkart.com"
                                        "YouTube" -> "https://www.youtube.com"
                                        "Twitter" -> "https://www.twitter.com"
                                        else -> ""
                                    }
                                )
                                startActivity(intent)
                            }) {
                                Text("Go To Site")
                            }
                        }
                    }
                }
            }

@Composable
fun RadioButtonGroup(options: List<String>, selectedOption: String, onOptionSelected: (String) -> Unit) {
    options.forEach { text ->
        Row(Modifier.selectable(selected = (text == selectedOption), onClick = { onOptionSelected(text) })) {
            RadioButton(selected = (text == selectedOption), onClick = null)
            Text(text = text)
        }
    }
}


