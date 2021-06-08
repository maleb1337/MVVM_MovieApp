package cl.maleb.testtransbank.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.maleb.testtransbank.R
import cl.maleb.testtransbank.api.list.MovieListData
import cl.maleb.testtransbank.databinding.FragmentMovieListBinding
import cl.maleb.testtransbank.utils.Resource
import cl.maleb.testtransbank.utils.gone
import cl.maleb.testtransbank.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : Fragment(R.layout.fragment_movie_list) {

    private val viewModel: MovieListViewModel by viewModels()

    private lateinit var movieListAdapter: MovieListAdapter

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpView()
        initObservers()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpView() {
        movieListAdapter = MovieListAdapter()
        binding.apply {
            recyclerView.apply {
                adapter = movieListAdapter
                layoutManager = LinearLayoutManager(context)
            }

            swipeRefreshLayout.setOnRefreshListener {
                viewModel.getMovieList()
            }
        }
        viewModel.getMovieList()
    }

    private fun initObservers() {
        viewModel.movieListLiveData.observe(viewLifecycleOwner, { result ->
            when (result) {
                is Resource.Error -> showErrorView(result.error)
                is Resource.Loading -> showLoadingView()
                is Resource.Success -> showSuccessView(result.data)
            }
        })
    }

    private fun showSuccessView(data: MovieListData?) {
        binding.apply {
            progressBar.gone()
            swipeRefreshLayout.isRefreshing = false
            // set data to controls
            movieListAdapter.submitList(data?.results)
        }
    }

    private fun showLoadingView() {
        binding.progressBar.visible()
    }

    private fun showErrorView(error: Throwable?) {
        binding.apply {
            progressBar.gone()
            textViewError.apply {
                visible()
                text = error?.localizedMessage
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}