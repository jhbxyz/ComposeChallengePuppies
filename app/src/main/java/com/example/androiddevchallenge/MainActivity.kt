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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
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
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.view.CommonTitle

class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel> {
        MainViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(mainViewModel) {
                    PuppiesDetailActivity.launchActivity(this, it)
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(viewModel: MainViewModel, action: (bean: DogBean) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    CommonTitle("Puppies List")
                },
                contentColor = purple200
            )
        },
        content = {
            Surface(color = MaterialTheme.colors.background) {
                LazyColumn() {
                    viewModel.mViewModel.value?.let {
                        items(it) { bean ->
                            DogList(bean, action)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun DogList(bean: DogBean, action: (bean: DogBean) -> Unit) {

    Card(
        elevation = 4.dp,
        shape = shapes.small,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
            .clickable {
                action.invoke(bean)
            }
    ) {

        Column(
            Modifier
                .padding(PaddingValues(Dp(10f)))
                .fillMaxWidth()
                .background(color = purple200),

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
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
        }
    }
}
