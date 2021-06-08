package cl.maleb.testtransbank.ui.list

sealed class MovieListEvent {
    data class NavigateToDetailScreen(val movieIdentifier: String) : MovieListEvent()
}