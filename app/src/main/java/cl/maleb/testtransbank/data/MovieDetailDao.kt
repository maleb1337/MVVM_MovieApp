package cl.maleb.testtransbank.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.maleb.testtransbank.api.detail.MovieDetailData
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetail(movieDetailData: MovieDetailData)

    @Query("SELECT * FROM movieDetailDataTable")
    fun getMovieDetail(): Flow<MovieDetailData>

    @Query("DELETE FROM movieDetailDataTable")
    suspend fun deleteMovieDetail()
}