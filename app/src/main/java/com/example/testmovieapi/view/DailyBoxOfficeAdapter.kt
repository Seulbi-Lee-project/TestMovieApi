package com.example.testmovieapi.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testmovieapi.data.MovieItems
import com.example.testmovieapi.databinding.DailyBoxOfficeItemsBinding

class DailyBoxOfficeAdapter(val movieList:List<MovieItems>): RecyclerView.Adapter<DailyBoxOfficeAdapter.Holder>() {
    inner class Holder(val binding: DailyBoxOfficeItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.movieTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = DailyBoxOfficeItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = "${movieList[position].ranking} : ${movieList[position].title}"
    }

}