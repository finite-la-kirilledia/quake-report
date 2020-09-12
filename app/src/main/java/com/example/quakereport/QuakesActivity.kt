package com.example.quakereport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quakereport.databinding.ActivityQuakesBinding
import kotlinx.android.synthetic.main.activity_quakes.*

class QuakesActivity : AppCompatActivity() {

    private val quakeViewModel: QuakeViewModel by lazy {
        ViewModelProvider(this).get(QuakeViewModel::class.java)
    }

    private val quakeAdapter: QuakeAdapter = QuakeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityQuakesBinding = DataBindingUtil.setContentView(this, R.layout.activity_quakes)
        binding.lifecycleOwner = this
        binding.viewModel = quakeViewModel

        quakes_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = quakeAdapter
        }

        quakeViewModel.quakes.observe(this, Observer { quakeAdapter.quakes = it })
    }
}
