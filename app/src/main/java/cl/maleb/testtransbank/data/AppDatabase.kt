package cl.maleb.testtransbank.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cl.maleb.testtransbank.api.detail.MovieDetailData
import cl.maleb.testtransbank.api.list.MovieListData
import cl.maleb.testtransbank.utils.Converters

@Database(
    entities = [MovieDetailData::class, MovieListData::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieListDao(): MovieListDao

    abstract fun movieDetailDao(): MovieDetailDao
}