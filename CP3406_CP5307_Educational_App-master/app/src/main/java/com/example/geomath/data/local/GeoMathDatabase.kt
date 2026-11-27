package com.example.geomath.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [QuizResultEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GeoMathDatabase : RoomDatabase() {

    abstract fun quizResultDao(): QuizResultDao

    companion object {

        @Volatile
        private var INSTANCE: GeoMathDatabase? = null

        fun getDatabase(context: Context): GeoMathDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GeoMathDatabase::class.java,
                    "geomath_database"
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}