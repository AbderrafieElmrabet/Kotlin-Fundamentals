package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollingApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollingApp() {
    ImageAndButton()
}

@Composable

fun ImageAndButton(){
    var result by remember { mutableStateOf(1) }
    val imageOfDice = when(result){
        1 -> R.drawable.one
        2 -> R.drawable.two
        3 -> R.drawable.three
        4 -> R.drawable.four
        5 -> R.drawable.five
        else -> R.drawable.six

    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
        ,modifier = Modifier.fillMaxSize().wrapContentSize(align = Alignment.Center)
    ){
        Image(painter = painterResource(id = imageOfDice), contentDescription = "Dice Image")
        Button(onClick = {result = (1..6).random()}) {
            Text(text = "Roll !")
        }
    }
}