package com.example.kevinlay.mvvm_boiler_plate_kotlin.dagger

import com.example.kevinlay.mvvm_boiler_plate_kotlin.ui.MainFragment
import dagger.Component

@Component(modules = [AppModule::class])
abstract class AppComponent {
    abstract fun inject(fragment: MainFragment)
}