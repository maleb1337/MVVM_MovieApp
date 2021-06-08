package cl.maleb.testtransbank.data.repository

import androidx.room.withTransaction
import cl.maleb.testtransbank.api.MovieApiService
import cl.maleb.testtransbank.data.AppDatabase
import cl.maleb.testtransbank.utils.networkBoundResource
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApiService: MovieApiService,
    private val appDatabase: AppDatabase
) {

    private val movieListDao = appDatabase.movieListDao()
    private val movieDetailDao = appDatabase.movieDetailDao()

    fun getMovieList() = networkBoundResource(
        databaseQuery = {
            movieListDao.getAllMovies()
        },
        networkCall = {
            movieApiService.getMovieList()
        },
        saveCallResult = {
            appDatabase.withTransaction {
                movieListDao.deleteAllMovies()
                movieListDao.insertMovieList(it)
            }
        }
    )

    fun getMovieDetail(movieIdentifier: String) = networkBoundResource(
        databaseQuery = {
            movieDetailDao.getMovieDetail()
        },
        networkCall = {
            movieApiService.getMovieDetail(movieId = movieIdentifier)
        },
        saveCallResult = {
            appDatabase.withTransaction {
                movieDetailDao.deleteMovieDetail()
                movieDetailDao.insertMovieDetail(it)
            }
        }
    )

}