package com.example.animatetext.src

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sss.ui.theme.AppTheme

@Composable
fun PartOne() {

    // // base canvas (not work with lazy column)
//    Canvas(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Green)
//    ) {
//        val canvasWidth = size.width
//        val canvasHeight = size.height
//
//        drawLine(
//            start = Offset(x = canvasWidth, y = 0f),
//            end = Offset(x = 0f, y = canvasHeight),
//            color = Color.Blue,
//            strokeWidth = 5f
//        )
//        drawCircle(
//            color = Color.Blue,
//            center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
//            radius = size.minDimension / 4
//        )
//    }


// // for old version
    Text(
        text = "PART I. onDrawWithContent brush",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 20.dp)
    )

    Text(
        text = "Text in Compose ❤️",
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp,
        modifier = Modifier
            .graphicsLayer(alpha = 0.99f)
            .drawWithCache {
                val brush = Brush.horizontalGradient(
                    0.0f to Color.Red,
                    0.2f to Color.Blue,
                    0.4f to Color.Yellow,
                    0.6f to Color.Cyan
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(brush = brush, blendMode = BlendMode.SrcAtop)
                }
            }
    )

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PartOnePreview() {
    AppTheme {
        PartOne()
    }
}