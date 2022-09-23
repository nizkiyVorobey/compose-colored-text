package com.example.animatetext.src

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sss.ui.theme.AppTheme

@OptIn(ExperimentalTextApi::class)
@Composable
fun PartFive() {
    val rainbowColors = listOf(
        Color(0xFFFF685D),
        Color(0xFFFF64F0),
        Color(0xFF5155FF),
        Color(0xFF54EDFF),
//        Color(0xFF5BFF7B),
//        Color(0xFFFDFF59),
//        Color(0xFFFFCA55),
    )

    var text by remember { mutableStateOf("Hello world!") }
    val brush = remember {
        Brush.linearGradient(
            colors = rainbowColors
        )
    }


    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "PART V. TextField Brush.linearGradient",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)
        )

        TextField(
            value = text,
            onValueChange = { text = it },
            textStyle = TextStyle(brush = brush, fontWeight = FontWeight.Bold, fontSize = 20.sp),
            modifier = Modifier.width(200.dp),

            )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PartFivePreview() {
    AppTheme {
        PartFive()
    }
}