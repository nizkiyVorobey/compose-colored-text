package com.example.animatetext.src

import android.util.Log
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sss.ui.theme.AppTheme

@OptIn(ExperimentalTextApi::class)
@Composable
fun PartSix(startAnimate: Boolean) {
    var textAnimate by remember { mutableStateOf(true) }
    val transition = updateTransition(textAnimate, label = "text animate")

    Log.d("SSSS", textAnimate.toString())
    val animateScaleX by transition.animateFloat(
        label = "animateScaleX",
        transitionSpec = { tween(durationMillis = 3000, easing = LinearEasing) },
        targetValueByState = { state ->
            when (state) {
                true -> 1.5f
                false -> 1f
            }
        },
    )
    val animateSkewX by transition.animateFloat(
        label = "animateSkewX",
        transitionSpec = { tween(durationMillis = 3000, easing = LinearEasing) },
        targetValueByState = { state ->
            when (state) {
                true -> .4f
                false -> 0f
            }
        },
    )
    val animateBackground by transition.animateColor(
        label = "animateBackground",
        transitionSpec = { tween(durationMillis = 3000, easing = LinearEasing) },
        targetValueByState = { state ->
            when (state) {
                true -> Color.Green
                false -> Color.Transparent
            }
        },
    )


    val rainbowColors = listOf(
        Color(0xFFFF685D),
        Color(0xFFFF64F0),
        Color(0xFF5155FF),
        Color(0xFF54EDFF),
    )

    LaunchedEffect(startAnimate) {
        if (startAnimate) {
            textAnimate = false
        }
    }

   Column() {
       Text(
           text = "PART VI. buildAnnotatedString",
           fontSize = 25.sp,
           fontWeight = FontWeight.Bold,
           modifier = Modifier.padding(top = 20.dp)
       )


       Text(
           buildAnnotatedString {
               withStyle(
                   style = SpanStyle(
                       background = animateBackground,
                       textGeometricTransform = TextGeometricTransform(
//                        scaleX = 1.5f,
//                        skewX = .4f
                           scaleX = animateScaleX,
                           skewX = animateSkewX
                       )
                   )
               ) {
                   append("Do not allow people to dim your shine ")
               }
               withStyle(
                   SpanStyle(
                       brush = Brush.linearGradient(
                           colors = rainbowColors
                       ),
                       fontWeight = FontWeight.Bold
                   )
               ) {
                   append("because they are blinded.")
               }
               append("Tell them to put some sunglasses on.")
           }
       )
   }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PartSixPreview() {
    AppTheme {
        PartSix(false)
    }
}