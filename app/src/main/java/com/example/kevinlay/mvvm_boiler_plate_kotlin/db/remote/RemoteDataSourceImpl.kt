package com.example.kevinlay.mvvm_boiler_plate_kotlin.db.remote

import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.model.AppEntity
import io.reactivex.Single

class RemoteDataSourceImpl: RemoteDataSource {

    override fun saveAppEntity(appEntity: AppEntity) {

    }

    override fun getAllAppEntity(): Single<List<AppEntity>> {
        return Single.just(ArrayList())
    }
}