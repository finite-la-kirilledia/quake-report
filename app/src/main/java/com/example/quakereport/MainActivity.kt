package com.example.quakereport

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val quakes = listOf(
        "San Francisco",
        "London",
        "Tokyo",
        "Mexico City",
        "Moscow",
        "Rio de Janeiro",
        "Paris"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quakes_list_view.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, quakes)
    }
}
