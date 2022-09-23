package com.example.animatetext.src

import android.graphics.Shader
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sss.ui.theme.AppTheme

@OptIn(ExperimentalTextApi::class)
@Composable
fun PartThree(text: String) {
    Column() {
        Text(
            text = "PART III. TextStyle TileMode.Repeated ",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 20.dp),
        )
        class ScaledThirdBrush(val shaderBrush: ShaderBrush) : ShaderBrush() {
            override fun createShader(size: Size): Shader {
                return shaderBrush.createShader(size / 3f)
            }
        }

        Text(
            text = text,
            style = TextStyle(
                brush = ScaledThirdBrush(
                    Brush.linearGradient(
                        colors = listOf(Color.Blue, Color.Magenta),
                        tileMode = TileMode.Repeated
                    ) as ShaderBrush
                )
            )
        )

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PartThreePreview() {
    AppTheme {
        PartThree(
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like). It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy."
        )
    }
}