package com.example.amphibiansapp

import android.app.Application
import com.example.amphibiansapp.data.AppContainer
import com.example.amphibiansapp.data.DefaultAppContainer

class AmphibianApplication: Application() {


     lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer=DefaultAppContainer()
    }
}