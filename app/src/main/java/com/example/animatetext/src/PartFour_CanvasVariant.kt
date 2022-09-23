package com.example.animatetext.src

import android.graphics.BitmapShader
import android.graphics.Shader
import android.graphics.Typeface
import android.os.Build
import android.text.StaticLayout
import android.text.TextPaint
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.animatetext.R
import com.example.sss.ui.theme.AppTheme


const val text =
    "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like). It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy.️"

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun PartFour_CanvasVariant() {
    val res = LocalContext.current.resources

    val textPaint = TextPaint().apply {
        textSize = 54f
        typeface = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD)
        shader = BitmapShader(
            ImageBitmap.imageResource(res, R.mipmap.compose_logo).asAndroidBitmap(),
            Shader.TileMode.CLAMP,
            Shader.TileMode.CLAMP,
        )
    }

    // for multiline text
    val staticLayout = StaticLayout.Builder
        .obtain(
            text,
            0,
            text.length,
            textPaint,
            text.length,

            )
        .build()

    Column() {
        Text(
            text = text,
            modifier = Modifier
                .drawWithCache {
                    onDrawWithContent {
                        drawIntoCanvas {
                            staticLayout.draw(it.nativeCanvas)
                        }
                    }
                }
        )
    }

}


@RequiresApi(Build.VERSION_CODES.M)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PartEightPreview() {
    AppTheme {
        PartFour_CanvasVariant()
    }
}