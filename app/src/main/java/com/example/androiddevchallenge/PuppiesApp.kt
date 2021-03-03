package com.example.androiddevchallenge

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * @author Jiang HaiBo
 * @date 2021/3/2
 */
class PuppiesApp : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var app: Context
    }

    override fun onCreate() {
        super.onCreate()
        app = applicationContext
    }
}