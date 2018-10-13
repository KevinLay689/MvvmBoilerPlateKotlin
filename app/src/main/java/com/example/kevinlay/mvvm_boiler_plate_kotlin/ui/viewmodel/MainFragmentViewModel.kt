package com.example.kevinlay.mvvm_boiler_plate_kotlin.ui.viewmodel

import android.arch.lifecycle.ViewModel
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.AppRepository
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.model.AppEntity
import io.reactivex.subjects.BehaviorSubject

class MainFragmentViewModel(private val appRepository: AppRepository): ViewModel() {

    val entities: BehaviorSubject<List<AppEntity>> = BehaviorSubject.create()

    fun saveClicked(userId: String) {
        appRepository.saveAppEntity(AppEntity(userId))
    }

    fun loadClicked() {
        appRepository.getAppEntity()
                .subscribe { entity ->
                    entities.onNext(entity)
                }
    }
}