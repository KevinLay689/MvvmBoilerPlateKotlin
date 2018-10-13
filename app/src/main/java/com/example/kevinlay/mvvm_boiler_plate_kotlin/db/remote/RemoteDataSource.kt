package com.example.kevinlay.mvvm_boiler_plate_kotlin.db.remote

import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.model.AppEntity
import io.reactivex.Single

interface RemoteDataSource {
    fun saveAppEntity(appEntity: AppEntity)

    fun getAllAppEntity(): Single<List<AppEntity>>
}