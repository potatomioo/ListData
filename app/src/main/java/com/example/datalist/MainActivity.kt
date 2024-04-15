package com.example.datalist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var name by remember {
                mutableStateOf("")
            }
            var names by remember {
                mutableStateOf(listOf<String>())
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(
                            color = Color.White,
                            RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp)
                        )
                ) {


                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Text(text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 30.sp
                                )
                            ){
                                append("L")
                            }
                            append("istData")
                        },
                            color = Color.DarkGray,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center,
                            //textDecoration = TextDecoration.Underline
                            //Importing Font Style to AS
                        )

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = name,
                            onValueChange = { content ->
                                name = content
                            },
                            label = {
                                Text(text = "Name")
                            },
                            supportingText = {
                                Text(text = "${name.length}/20")
                            },
                            singleLine = true
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Button(
                            onClick = {
                                if (name.isNotBlank()) {
                                    names = names + name
                                }
                                name = ""
                            }
                        ) {
                            Text(text = "Add")
                        }
                        androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(5.dp))
                        Button(
                            onClick = {
                                names = kotlin.collections.emptyList()
                            }
                        ) {
                            Text(text = "Clear")
                        }



                    }




                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .align(Alignment.BottomCenter)
                        .background(
                            color = Color.White,
                        )
                ) {
                    LazyColumn {
                        items(names){
                                cout->
                            Text(text = cout,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                            )
                            Divider()
                        }
                    }
                }
            }
        }
    }
}

    
//@Composable

//@Preview
//@Composable
//private fun hey() {
//    input()
//}