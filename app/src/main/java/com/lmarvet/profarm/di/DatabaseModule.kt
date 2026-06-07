package com.lmarvet.profarm.di

import android.content.Context
import androidx.room.Room
import com.lmarvet.profarm.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "lmar_vet_profarm.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideFarmDao(database: AppDatabase) = database.farmDao()

    @Provides
    @Singleton
    fun provideFlockDao(database: AppDatabase) = database.flockDao()

    @Provides
    @Singleton
    fun provideHealthRecordDao(database: AppDatabase) = database.healthRecordDao()

    @Provides
    @Singleton
    fun provideTreatmentDao(database: AppDatabase) = database.treatmentDao()

    @Provides
    @Singleton
    fun provideDailyRecordDao(database: AppDatabase) = database.dailyRecordDao()

    @Provides
    @Singleton
    fun provideReportDao(database: AppDatabase) = database.reportDao()
}
