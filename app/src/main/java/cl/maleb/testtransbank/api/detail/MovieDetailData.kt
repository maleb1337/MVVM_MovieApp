package cl.maleb.testtransbank.api.detail

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieDetailDataTable")
data class MovieDetailData(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val budget: Int? = null,
    val genres: List<Genre>? = null,
    val homepage: String? = null,
    @PrimaryKey val id: Int,
    val imdb_id: String? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val production_companies: List<ProductionCompany>? = null,
    val production_countries: List<ProductionCountry>? = null,
    val release_date: String? = null,
    val revenue: Int? = null,
    val runtime: Int? = null,
    val spoken_languages: List<SpokenLanguage>? = null,
    val status: String? = null,
    val tagline: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)