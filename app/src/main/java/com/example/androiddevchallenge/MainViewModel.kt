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