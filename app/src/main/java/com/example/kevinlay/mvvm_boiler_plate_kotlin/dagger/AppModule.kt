package com.example.kevinlay.mvvm_boiler_plate_kotlin.dagger

import android.arch.persistence.room.Room
import android.content.Context
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.AppRepository
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.AppDatabase
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.LocalDataSource
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.LocalDataSourceImpl
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.local.dao.AppDao
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.remote.RemoteDataSource
import com.example.kevinlay.mvvm_boiler_plate_kotlin.db.remote.RemoteDataSourceImpl
import com.example.kevinlay.mvvm_boiler_plate_kotlin.ui.viewmodel.MainFragmentViewModelFactory
import com.example.kevinlay.mvvm_boiler_plate_kotlin.util.OfflineManager
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AppModule(private val context: Context) {

    private val roomDatabase: AppDatabase = Room.databaseBuilder(context,
            AppDatabase::class.java,
            "AppDatabase")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Named("context")
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Named("applicationContext")
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }

    @Provides
    fun provideAppDao(): AppDao {
        return roomDatabase.getAppDao()
    }

    @Provides
    fun provideAppRepository(localDataSource: LocalDataSource,
                             remoteDataSource: RemoteDataSource,
                             offlineManager: OfflineManager): AppRepository {
        return AppRepository(localDataSource,
                remoteDataSource,
                offlineManager)
    }

    @Provides
    fun provideMainFragmentViewModelFactory(appRepository: AppRepository):
            MainFragmentViewModelFactory {
        return MainFragmentViewModelFactory(appRepository)
    }

    @Provides
    fun provideLocalDataSource(appDao: AppDao): LocalDataSource {
        return LocalDataSourceImpl(appDao)
    }

    @Provides
    fun provideRemoteDataSource(): RemoteDataSource {
        return RemoteDataSourceImpl()
    }

    @Provides
    fun provideOfflineManager(): OfflineManager {
        return OfflineManager()
    }
}