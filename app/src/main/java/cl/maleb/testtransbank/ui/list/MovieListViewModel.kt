package cl.maleb.testtransbank.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.maleb.testtransbank.api.list.MovieListData
import cl.maleb.testtransbank.data.repository.MovieRepository
import cl.maleb.testtransbank.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {

    private val movieListMutableLiveData = MutableLiveData<Resource<MovieListData>>()
    val movieListLiveData: LiveData<Resource<MovieListData>> = movieListMutableLiveData

    fun getMovieList() =
        viewModelScope.launch {
            repository.getMovieList().collect {
                movieListMutableLiveData.value = it
            }
        }

}