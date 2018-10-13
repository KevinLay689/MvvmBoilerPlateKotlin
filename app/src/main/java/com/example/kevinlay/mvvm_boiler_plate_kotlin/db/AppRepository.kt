package com.example.kevinlay.mvvm_boiler_plate_kotlin.db

import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.LocalDataSource
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.model.AppEntity
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.remote.RemoteDataSource
import com.example.kevinlay.mvvm_boiler_plate_kotlin.util.OfflineManager
import io.reactivex.Single

class AppRepository(private val localDataSource: LocalDataSource,
                    private val remoteDataSource: RemoteDataSource,
                    private val offlineManager: OfflineManager) {

    private var cache = ArrayList<AppEntity>()

    private var isCacheDirty: Boolean = false

    fun getAppEntity(): Single<ArrayList<AppEntity>> {
        return if (!isCacheDirty) {
            Single.just(cache)
        } else if (offlineManager.isOffline()) {
            localDataSource.getAllAppEntity()
                    .map { updateCache(it) }
                    .flatMap { Single.just(cache) }
        } else {
            remoteDataSource.getAllAppEntity()
                    .map { updateCache(it) }
                    .flatMap { Single.just(cache) }
        }
    }

    fun saveAppEntity(appEntity: AppEntity) {

        remoteDataSource.getAllAppEntity().subscribe { entities ->
            localDataSource.saveAppEntity(appEntity)
            remoteDataSource.saveAppEntity(appEntity)
            updateCache(entities)
            updateCache(appEntity)
        }
    }

    private fun updateCache(updatedList: List<AppEntity>) {
        cache = updatedList as ArrayList<AppEntity>
    }

    private fun updateCache(appEntity: AppEntity) {
        cache.add(appEntity)
    }
}