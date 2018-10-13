package com.example.kevinlay.mvvm_boiler_plate_kotlin.ui.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.AppRepository

class MainFragmentViewModelFactory(private val appRepository: AppRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainFragmentViewModel(appRepository) as T
    }
}