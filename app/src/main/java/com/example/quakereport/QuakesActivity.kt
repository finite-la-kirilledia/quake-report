package com.example.quakereport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_quakes.*

class QuakesActivity : AppCompatActivity() {

    private val quakeViewModel: QuakeViewModel by lazy {
        ViewModelProviders.of(this).get(QuakeViewModel::class.java)
    }

    private val quakeAdapter: QuakeAdapter = QuakeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quakes)

        quakes_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = quakeAdapter
        }

        quakeViewModel.quakes.observe(this, Observer { quakeAdapter.quakes = it })
    }
}
