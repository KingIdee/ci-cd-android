package dev.idee.cicdandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieListAdapter(
    diffCallback: DiffUtil.ItemCallback<MovieModel>
) : ListAdapter<MovieModel, MovieListAdapter.MovieViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) = holder.bind(getItem(position))

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image:ImageView = itemView.findViewById(R.id.movieImage)
        private val title:TextView = itemView.findViewById(R.id.movieTitle)

        fun bind(item: MovieModel) {
            title.text = item.title

            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w500${item.backdropPath}")
                .centerCrop()
                .into(image)

        }

    }


}
