package com.example.quakereport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.quake_list_item.view.*

class QuakeAdapter(private val quakes: List<Quake>) : RecyclerView.Adapter<QuakeAdapter.QuakeViewHolder>() {

    override fun getItemCount() = quakes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuakeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quake_list_item, parent, false)
        return QuakeViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuakeViewHolder, position: Int) {
        val item = quakes[position]

        holder.itemView.magnitude.text = item.magnitude.toString()
        holder.itemView.location_offset
        holder.itemView.primary_location.text = item.place
        holder.itemView.date
        holder.itemView.time.text = item.time.toString()
    }

    class QuakeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}