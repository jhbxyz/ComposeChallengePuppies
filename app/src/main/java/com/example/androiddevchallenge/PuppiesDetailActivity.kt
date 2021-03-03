/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.bean.DogBean
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.purple200
import com.example.androiddevchallenge.ui.view.CommonTitle
import com.example.androiddevchallenge.util.showToast

/**
 * @author Jiang HaiBo
 * @date 2021/3/2
 */

private const val DOG_BEAN = "dog_bean"

class PuppiesDetailActivity : AppCompatActivity() {

    companion object {
        fun launchActivity(activity: AppCompatActivity, bean: DogBean) {
            val intent = Intent(activity, PuppiesDetailActivity::class.java)
            intent.putExtra(DOG_BEAN, bean)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                (intent.getSerializableExtra(DOG_BEAN) as? DogBean)?.let {
                    DetailApp(it)
                }
            }
        }
    }
}

@Composable
fun DetailApp(bean: DogBean) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    CommonTitle("${bean.name}'s Detail")
                }
            )
        },
        floatingActionButton = {
            AdoptButton(bean)
        },
    ) {

        Column(
            Modifier
                .padding(PaddingValues(Dp(10f)))
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(bean.resId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                contentDescription = bean.desc
            )
            Text(
                text = bean.name,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
                    .fillMaxWidth(),
                style = TextStyle(
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )

            Text(
                text = bean.desc,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
                    .fillMaxWidth(),
                style = TextStyle(
                    color = Color.DarkGray,
                    textAlign = TextAlign.Start,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            )
        }
    }
}

@Composable
private fun AdoptButton(dogBean: DogBean) {
    var isAdopt by mutableStateOf(dogBean.adopt)

    Card(
        elevation = 4.dp,
        shape = CircleShape,
        modifier = Modifier
            .size(75.dp, 75.dp)
            .clickable {
                if (!isAdopt) {
                    "You have adopted ${dogBean.name}".showToast()
                    isAdopt = true
                } else {
                    "You have adopted ${dogBean.name}".showToast()
                }
            }
    ) {
        Box(
            modifier = Modifier
                .background(purple200),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = if (isAdopt) "Adopted" else "Adopt",
                style = TextStyle(
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
        }
    }
}
