package com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local

import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.model.AppEntity
import io.reactivex.Completable
import io.reactivex.Single

interface LocalDataSource {
    fun saveAppEntity(appEntity: AppEntity): Completable

    fun getAllAppEntity(): Single<List<AppEntity>>
}