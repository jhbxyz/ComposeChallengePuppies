package com.example.androiddevchallenge.bean

import java.io.Serializable

/**
 * @author Jiang HaiBo
 * @date 2021/3/2
 */
data class DogBean(
    var name: String,
    var resId: Int,
    var desc: String,
    var adopt: Boolean
) : Serializable