package com.example.randomcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomcard.ui.theme.RandomCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomCardTheme {
                RandomCardApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RandomCardApp() {
// A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        RandomButtonAndCardImage(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}

@Composable
fun RandomButtonAndCardImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(0) }
    val imageResource = when(result) {
        0 -> R.drawable.card_back
        1 -> R.drawable.ace_diamonds
        2 -> R.drawable.two_clubs
        3 -> R.drawable.three_diamonds
        4 -> R.drawable.four_hearts
        5 -> R.drawable.five_clubs
        6 -> R.drawable.six_spades
        7 -> R.drawable.seven_hearts
        8 -> R.drawable.eight_diamonds
        9 -> R.drawable.nine_spades
        else -> R.drawable.ten_diamonds
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString(),
            modifier = Modifier.height(240.dp),
            contentScale = ContentScale.FillHeight,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                result = (1..10).random()
            },
            shape = CutCornerShape(10),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp,
                pressedElevation = 10.dp
            ),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            border = BorderStroke(2.dp, Color.White)
        ) {
            Text(
                text = stringResource(R.string.pick_button_text),
                fontSize = 24.sp
            )
        }
    }
}
