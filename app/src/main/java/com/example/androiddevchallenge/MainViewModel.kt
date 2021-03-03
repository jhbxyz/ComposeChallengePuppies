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

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androiddevchallenge.bean.DogBean
import com.example.androiddevchallenge.bean.dataDesc
import com.example.androiddevchallenge.bean.dataImage
import com.example.androiddevchallenge.bean.dataName

/**
 * @author Jiang HaiBo
 * @date 2021/3/2
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _liveData = MutableLiveData<List<DogBean>>()
    val mViewModel: LiveData<List<DogBean>> = _liveData

    init {
        initData()
    }

    private fun initData() {
        val tempList = mutableListOf<DogBean>()
        dataDesc.forEachIndexed { index, des ->
            tempList.add(DogBean(dataName[index], dataImage[index], des, false))
        }
        _liveData.value = tempList
    }
}
