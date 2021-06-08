package cl.maleb.testtransbank.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.maleb.testtransbank.api.list.MovieListData
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieList(movieList: MovieListData)

    @Query("SELECT * FROM movieListDataTable")
    fun getAllMovies(): Flow<MovieListData>

    @Query("DELETE FROM movieListDataTable")
    suspend fun deleteAllMovies()

}