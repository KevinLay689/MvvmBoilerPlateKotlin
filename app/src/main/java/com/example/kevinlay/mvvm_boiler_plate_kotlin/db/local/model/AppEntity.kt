package com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "AppTable")
data class AppEntity(@PrimaryKey val id: String)