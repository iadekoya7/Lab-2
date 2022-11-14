package com.iadekoya.lab2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iadekoya.lab2.R

@Composable
fun LabTwoComposable(){

    var userInput by remember{ mutableStateOf("") }
    var outputText by remember { mutableStateOf("Output Text Composable") }
    var imageChangeBoolean by remember { mutableStateOf(true) }

    Column {
        UITopAppBar(
            title = "Lab 2 Top Bar"
        )
        LazyColumn(modifier = Modifier.weight(1f)){
            item {
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    label = { Text(text = stringResource(id = R.string.user_input)) },
                    value = userInput,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                    onValueChange = { userInput = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .align(CenterHorizontally),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = outputText,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Image(
                    painter = painterResource(
                        id = if(!imageChangeBoolean)
                            R.drawable.image_of_dog
                        else
                            R.drawable.school),
                    contentDescription = stringResource(id = R.string.image_string),
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .padding(90.dp)
                        .size(190.dp)
                        .clip(CircleShape)
                        .border(5.dp, Color.Black, CircleShape),
                )
                Button(
                    onClick = { imageChangeBoolean = !imageChangeBoolean
                        outputText = userInput },
                    modifier = Modifier
                        .padding(30.dp)
                        .height(50.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text(text = "Click Me", fontSize = 15.sp)
                }
            }
        }
    }
}