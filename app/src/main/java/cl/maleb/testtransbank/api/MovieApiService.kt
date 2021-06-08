package cl.maleb.testtransbank.api

import cl.maleb.testtransbank.BuildConfig
import cl.maleb.testtransbank.api.detail.MovieDetailData
import cl.maleb.testtransbank.api.list.MovieListData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    companion object {
        const val GET_MOVIE_LIST = "movie/popular"
        const val GET_MOVIE_DETAIL = "movie/{movieId}"
    }

    @GET(GET_MOVIE_LIST)
    suspend fun getMovieList(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("language") endLanguage: String = "en-US",
        @Query("page") pageSize: Int = 1
    ): MovieListData

    @GET(GET_MOVIE_DETAIL)
    suspend fun getMovieDetail(
        @Path("movieId") movieId: String,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): MovieDetailData
}