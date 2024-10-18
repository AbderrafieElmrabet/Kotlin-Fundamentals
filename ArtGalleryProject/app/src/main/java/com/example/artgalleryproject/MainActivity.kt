package com.example.artgalleryproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PlainPage()
            }
        }
    }
}

@Composable
fun PlainPage() {
    val result = remember { mutableStateOf(1) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.rabatpic),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.5F
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val title = when(result.value){
                1 -> "The City Of Rabat"
                2 -> "The Food Of Rabat"
                3 -> "The Artifacts Of Rabat"
                else -> "The City Of Rabat"
            }

            val image = when (result.value) {
                1 -> R.drawable.rabat
                2 -> R.drawable.food
                3 -> R.drawable.artifact
                else -> R.drawable.rabat
            }

            val description = when(result.value){
                1 -> "Rabat, the capital city of Morocco, is situated along the Atlantic coast and is known for its rich history and blend of modernity and tradition. As one of the country's four imperial cities, Rabat boasts a variety of historical sites"
                2 -> "Rabat's cuisine features traditional dishes like tagine and couscous, often seasoned with aromatic spices. The city is also known for its vibrant street food, including harira soup and fresh seafood"
                3 -> "Rabat is home to rich artifacts, including the historic Kasbah of the Oudaias, intricate zellij tiles, and ancient Roman ruins at Chellah. The city also features the Royal Palace and the striking Hassan Tower, showcasing its architectural heritage."
                else -> "The City Of Rabat"
            }
            Text(
                text = title,
                color = Color.Black,
                fontSize = 35.sp,
                modifier = Modifier
                    .padding(16.dp)
            )
            Image(
                painter = painterResource(id = image),
                contentDescription = "Rabat",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 60.dp)
                    .height(230.dp)
                    .border(
                        width = 4.dp,
                        color = Color.White
                    )
            )
            Text(
                text = description,
                color = Color.Black,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(16.dp)
            )
            Button(onClick = {
                result.value = if (result.value < 3) result.value + 1 else 1
            }) {
                Text(text = "Switch")
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        PlainPage()
    }
}