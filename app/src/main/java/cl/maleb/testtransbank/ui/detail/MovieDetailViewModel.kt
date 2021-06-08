package cl.maleb.testtransbank.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.maleb.testtransbank.api.detail.MovieDetailData
import cl.maleb.testtransbank.data.repository.MovieRepository
import cl.maleb.testtransbank.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val movieDetailMutableLiveData = MutableLiveData<Resource<MovieDetailData>>()
    val movieDetailLiveData: LiveData<Resource<MovieDetailData>> = movieDetailMutableLiveData

    fun getMovieDetail(movieIdentifier: String) =
        viewModelScope.launch {
            repository.getMovieDetail(movieIdentifier).collect {
                movieDetailMutableLiveData.value = it
            }
        }

}