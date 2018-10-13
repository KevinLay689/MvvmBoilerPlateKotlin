package com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.dao.AppDao
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.model.AppEntity

@Database(entities = [AppEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getAppDao(): AppDao
}