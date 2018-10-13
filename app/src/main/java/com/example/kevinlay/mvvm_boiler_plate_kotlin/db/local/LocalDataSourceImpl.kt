package com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local

import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.dao.AppDao
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.model.AppEntity
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class LocalDataSourceImpl(private val appDao: AppDao): LocalDataSource {

    override fun saveAppEntity(appEntity: AppEntity): Completable {
        return Completable.fromAction { appDao.saveAppEntity(appEntity) }
                .subscribeOn(Schedulers.io())
    }

    override fun getAllAppEntity(): Single<List<AppEntity>> {
        return appDao.getAppEntity()
                .subscribeOn(Schedulers.io())
    }
}