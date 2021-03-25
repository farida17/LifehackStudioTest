package com.farida.lifehackstudiotest

import androidx.multidex.MultiDexApplication
import com.farida.lifehackstudiotest.di.ApplicationComponent
import com.farida.lifehackstudiotest.di.ApplicationModule
import com.farida.lifehackstudiotest.di.DaggerApplicationComponent

class MyApplication: MultiDexApplication() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}