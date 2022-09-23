package com.example.animatetext.src

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sss.ui.theme.AppTheme


@Composable
fun Home(text: String) {
    val state = rememberScrollState()
    Column(
        Modifier
            .verticalScroll(state)
            .padding(bottom = 20.dp)
    ) {
        PartOne()
        // fro compose 1.2.0 and above
        PartTwo(text = text)
        PartThree(text = text)
        PartFour(text = text)
        PartFive()
        PartSix(startAnimate = state.value == state.maxValue)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextOnePreview() {
    AppTheme {
        Home(
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like). It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy."
        )
    }
}