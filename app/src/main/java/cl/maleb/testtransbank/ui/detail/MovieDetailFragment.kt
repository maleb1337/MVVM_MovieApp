package cl.maleb.testtransbank.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import cl.maleb.testtransbank.R
import cl.maleb.testtransbank.api.detail.MovieDetailData
import cl.maleb.testtransbank.databinding.FragmentMovieDetailBinding
import cl.maleb.testtransbank.utils.Resource
import cl.maleb.testtransbank.utils.gone
import cl.maleb.testtransbank.utils.visible
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private val args: MovieDetailFragmentArgs by navArgs()

    private val viewModel: MovieDetailViewModel by viewModels()

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpView()
        initObservers()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpView() {
        viewModel.getMovieDetail(args.identifier.orEmpty())
    }

    private fun initObservers() {
        viewModel.movieDetailLiveData.observe(viewLifecycleOwner, { result ->
            when (result) {
                is Resource.Error -> showErrorView(result.error)
                is Resource.Loading -> showLoadingView()
                is Resource.Success -> showSuccessView(result.data)
            }
        })
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

    private fun showSuccessView(data: MovieDetailData?) {
        binding.apply {
            progressBar.gone()
            data?.apply {
                Glide.with(requireContext())
                    .load(imageUrl)
                    .into(imageView)

                textViewTitle.text = title
                textViewDescription.text = overview
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}