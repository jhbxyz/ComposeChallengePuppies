package com.example.androiddevchallenge.ui.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

/**
 * @author Jiang HaiBo
 * @date 2021/3/2
 */
@Composable
fun CommonTitle(name: String) {
    Text(
        text = name,
        style = TextStyle(
            color = Color.White,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    )
}