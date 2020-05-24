package com.example.quakereport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.quake_list_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class QuakeAdapter(private val quakes: List<Quake>) : RecyclerView.Adapter<QuakeAdapter.QuakeViewHolder>() {

    override fun getItemCount() = quakes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuakeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quake_list_item, parent, false)
        return QuakeViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuakeViewHolder, position: Int) {
        val item = quakes[position]
        val itemView = holder.itemView

        DrawableCompat.setTint(
            DrawableCompat.wrap(itemView.magnitude.background),
            ContextCompat.getColor(itemView.context, getMagnitudeColor(item.magnitude))
        )
        itemView.magnitude.text = item.magnitude.toString()

        val originalLocation = item.place
        val locationSeparator = " of "
        val locationOffset: String
        val primaryLocation: String
        if (originalLocation.contains(locationSeparator)) {
            val parts = originalLocation.split(locationSeparator)
            locationOffset = parts[0] + locationSeparator
            primaryLocation = parts[1]
        } else {
            locationOffset = "Near the"
            primaryLocation = originalLocation
        }
        itemView.location_offset.text = locationOffset
        itemView.primary_location.text = primaryLocation

        val datetime = Date(item.time)
        itemView.date.text = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(datetime)
        itemView.time.text = SimpleDateFormat("HH:mm", Locale.ENGLISH).format(datetime)
    }

    class QuakeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    private fun getMagnitudeColor(magnitude: Double): Int {
        val magnitudeColorResourceId: Int
        val magnitudeFloor = Math.floor(magnitude).toInt()
        magnitudeColorResourceId = when (magnitudeFloor) {
            0, 1 -> R.color.magnitude1
            2 -> R.color.magnitude2
            3 -> R.color.magnitude3
            4 -> R.color.magnitude4
            5 -> R.color.magnitude5
            6 -> R.color.magnitude6
            7 -> R.color.magnitude7
            8 -> R.color.magnitude8
            9 -> R.color.magnitude9
            else -> R.color.magnitude10plus
        }
        return magnitudeColorResourceId
    }
}