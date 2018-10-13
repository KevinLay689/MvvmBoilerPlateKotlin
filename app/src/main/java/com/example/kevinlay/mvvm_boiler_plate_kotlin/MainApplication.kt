package com.example.kevinlay.mvvm_boiler_plate_kotlin

import android.app.Application
import com.example.kevinlay.mvvm_boiler_plate_kotlin.dagger.AppComponent
import com.example.kevinlay.mvvm_boiler_plate_kotlin.dagger.AppModule
import com.example.kevinlay.mvvm_boiler_plate_kotlin.dagger.DaggerAppComponent

class MainApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}
