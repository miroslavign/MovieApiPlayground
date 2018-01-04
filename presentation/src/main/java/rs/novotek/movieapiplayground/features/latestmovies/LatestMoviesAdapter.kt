/*
 * LatestMoviesAdapter.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 1/4/2017
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground.features.latestmovies

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import rs.novotek.domain.model.discover.Result
import rs.novotek.movieapiplayground.R

class LatestMoviesAdapter : RecyclerView.Adapter<LatestMoviesAdapter.ViewHolder>() {
    private val movies = mutableListOf<Result>()

    var onItemClick: (Result) -> Unit = {}

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        movies[position].apply {
            holder.noteText.text = this.originalTitle
        }
    }

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val noteText = LayoutInflater.from(parent.context)
                .inflate(R.layout.discover_movie_item, parent, false) as TextView
        val viewHolder = ViewHolder(noteText)
        noteText.setOnClickListener { onItemClick(movies[viewHolder.adapterPosition]) }
        return viewHolder
    }

    fun updateMovies(notes: List<Result>) {
        this.movies.clear()
        this.movies.addAll(notes)
        notifyDataSetChanged()
    }

    class ViewHolder(val noteText: TextView) : RecyclerView.ViewHolder(noteText)
}