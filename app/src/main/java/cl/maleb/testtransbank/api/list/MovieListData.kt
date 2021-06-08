package cl.maleb.testtransbank.api.list

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieListDataTable")
data class MovieListData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val page: Int? = null,
    val results: List<Result>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)