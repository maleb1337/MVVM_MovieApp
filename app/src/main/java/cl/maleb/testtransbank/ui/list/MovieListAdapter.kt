package cl.maleb.testtransbank.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cl.maleb.testtransbank.api.list.Result
import cl.maleb.testtransbank.databinding.ItemMovieListBinding
import com.bumptech.glide.Glide

class MovieListAdapter(private val listener: OnItemClickListener) :
    ListAdapter<Result, MovieListAdapter.MovieListViewHolder>(MovieListComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val binding =
            ItemMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem, listener)
        }
    }

    class MovieListViewHolder(private val binding: ItemMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Result, listener: OnItemClickListener) {
            binding.apply {
                root.setOnClickListener {
                    listener.onItemClick(result)
                }
                Glide.with(itemView)
                    .load(result.imageUrl)
                    .into(imageView)

                textViewTitle.text = result.title
                textViewSubtitle.text = result.overview
            }
        }
    }

    class MovieListComparator : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Result, newItem: Result) =
            oldItem == newItem

    }

    interface OnItemClickListener {
        fun onItemClick(result: Result)
    }


}