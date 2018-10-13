package com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.model.AppEntity
import io.reactivex.Single

@Dao
interface AppDao {

    @Query("SELECT * FROM AppTable")
    fun getAppEntity(): Single<List<AppEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAppEntity(appEntity: AppEntity)
}