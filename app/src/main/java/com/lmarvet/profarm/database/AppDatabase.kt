package com.lmarvet.profarm.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lmarvet.profarm.models.*

@Database(
    entities = [
        Farm::class,
        Flock::class,
        HealthRecord::class,
        Treatment::class,
        DailyRecord::class,
        Report::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun farmDao(): FarmDao
    abstract fun flockDao(): FlockDao
    abstract fun healthRecordDao(): HealthRecordDao
    abstract fun treatmentDao(): TreatmentDao
    abstract fun dailyRecordDao(): DailyRecordDao
    abstract fun reportDao(): ReportDao
}
