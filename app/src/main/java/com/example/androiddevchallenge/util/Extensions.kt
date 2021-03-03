package com.example.androiddevchallenge.util

import android.widget.Toast
import com.example.androiddevchallenge.PuppiesApp

/**
 * @author Jiang HaiBo
 * @date 2021/3/2
 */

fun String.showToast() = Toast.makeText(PuppiesApp.app, this, Toast.LENGTH_SHORT).show()

fun Any?.isNull() = this == null

fun String.logE(tag: String = "jianghaibo") {
    android.util.Log.e(tag, this)
}